package com.中间件.hbase.repo;

import com.中间件.hbase.constant.HbaseErrorEnum;
import com.中间件.hbase.constant.HbaseTableEnum;
import com.中间件.hbase.constant.HbbaseConstant;
import com.中间件.hbase.exceptions.HbaseException;
import com.中间件.hbase.exceptions.RestServiceException;
import com.中间件.hbase.mode.CrmKv;
import com.中间件.hbase.utils.HbaseQueryUtils;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * hbase 基础操作类（增/删/改/查）
 *
 */
@Repository
@Slf4j
public class HbaseRepo {

    @Resource(name = "hbaseConnection")
    @Setter
    private Connection connection;

    @Value("${hbase.tableNameSpace}")
    @Setter
    private String tableNameSpace;

    /**
     * 根据rowkey 查询一条数据
     *
     * @param hbaseTableEnum 表名,列族
     * @param rowKey         行键
     * @param columnNameList 列表字段
     * @return
     * @throws IOException
     */
    public CrmKv<String, Map<String, String>> get(HbaseTableEnum hbaseTableEnum, String rowKey, List<String> columnNameList) {
        if (hbaseTableEnum == null || StringUtils.isBlank(rowKey)) {
            return null;
        }

        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(buildTableName(hbaseTableEnum)));
            Get get = new Get(rowKey.getBytes());
            Result result = table.get(get);
            if (result.isEmpty()) {
                return null;
            }
            CrmKv<String, Map<String, String>> kv = HbaseQueryUtils.buildRowData(hbaseTableEnum.getFamilyName(), result, columnNameList);
            return kv;
        } catch (Exception e) {
            log.error("hbase get error", e);
            throw new HbaseException(HbaseErrorEnum.DB_CONNECTION_ERROR, e);
        } finally {
            if (table != null) {
                try {
                    table.close();
                } catch (Exception e) {
                    log.error("hbase get error", e);
                }
            }
        }
    }


    public List<CrmKv<String, Map<String, String>>> getList(HbaseTableEnum hbaseTableEnum, List<String> rowKeys, List<String> columnNameList) {
        if (hbaseTableEnum == null || rowKeys == null || rowKeys == null) {
            return new ArrayList<>(0);
        }

        List<Get> getList = rowKeys.stream()
                .filter(key -> StringUtils.isNotEmpty(key))
                .map(rowKey -> new Get(Bytes.toBytes(rowKey)))
                .collect(Collectors.toList());

        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(buildTableName(hbaseTableEnum)));
            Result[] results = table.get(getList);
            List<CrmKv<String, Map<String, String>>> rowDataList = HbaseQueryUtils.buildRowDataList(hbaseTableEnum.getFamilyName(), results, columnNameList);
            return rowDataList;
        } catch (Exception e) {
            log.error("hbase getlist error", e);
            throw new HbaseException(HbaseErrorEnum.DB_CONNECTION_ERROR, e);
        } finally {
            if (table != null) {
                try {
                    table.close();
                } catch (Exception e) {
                    log.error("hbase getList error", e);
                }
            }
        }
    }

    /**
     * 插入一条数据
     *
     * @param hbaseTableEnum 表名,列簇
     * @param rowData        行数据
     * @return
     */
    public void insert(HbaseTableEnum hbaseTableEnum, CrmKv<String, Map<String, String>> rowData) {
        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(buildTableName(hbaseTableEnum)));
            Put put = new Put(rowData.getKey().getBytes());
            rowData.getValue().entrySet().forEach(row -> {
                byte[] value = row.getValue() == null ? null : Bytes.toBytes(row.getValue());
                byte[] key = Bytes.toBytes(row.getKey());
                put.addColumn(hbaseTableEnum.getFamilyName().getBytes(), key, value);
            });
            table.put(put);
            table.close();
        } catch (Exception e) {
            log.error("hbase insert error", e);
            throw new HbaseException(HbaseErrorEnum.DB_CONNECTION_ERROR, e);
        } finally {
            if (table != null) {
                try {
                    table.close();
                } catch (Exception e) {
                    log.error("hbase table close error", e);
                }
            }
        }

    }

    /**
     * 更新商品信息
     * *  1.如果rowkey 有变化 ：执行 新增一条数据，然后在删除 老数据
     * *  2.如果rowkey 没变化 ：更新 记录
     *
     * @param hbaseTableEnum 列名 列族
     * @param oldRowKey      旧行键
     * @param rowData        行数据
     */
    public void update(HbaseTableEnum hbaseTableEnum, String oldRowKey, CrmKv<String, Map<String, String>> rowData) {
        try {
            insert(hbaseTableEnum, rowData);
            if (!StringUtils.equals(oldRowKey, rowData.getKey())) {
                delete(hbaseTableEnum, new LinkedList<String>() {{
                    add(oldRowKey);
                }});
            }
        } catch (RestServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("hbase update error", e);
            throw new HbaseException(HbaseErrorEnum.DB_CONNECTION_ERROR, e);
        }
    }

    /**
     * 删除数据 是彻底从hbase 删除掉
     * 支持 删除多条记录
     *
     * @param rowKeys
     * @throws IOException
     */
    public void delete(HbaseTableEnum hbaseTableEnum, List<String> rowKeys) {
        if (rowKeys == null || rowKeys.isEmpty()) {
            return;
        }

        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(buildTableName(hbaseTableEnum)));
            List<Delete> deletes = rowKeys.stream().filter(Objects::nonNull)
                    .map(rowKey -> new Delete(Bytes.toBytes(rowKey)))
                    .collect(Collectors.toList());
            table.delete(deletes);
        } catch (Exception e) {
            log.error("hbase delete error", e);
            throw new HbaseException(HbaseErrorEnum.DB_CONNECTION_ERROR, e);
        } finally {
            if (table != null) {
                try {
                    table.close();
                } catch (Exception e) {
                    log.error("table close error", e);
                }
            }
        }
    }

    /**
     * 查询接口
     *
     * @param hbaseTableEnum
     * @param scan
     * @return
     * @throws IOException
     */
    public List<CrmKv<String, Map<String, String>>> select(HbaseTableEnum hbaseTableEnum, @NonNull Scan scan, List<String> columnNameList) {
        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(buildTableName(hbaseTableEnum)));
            ResultScanner resultScanner = table.getScanner(scan);
            List<CrmKv<String, Map<String, String>>> resultList = new ArrayList<>(100);
            for (Result result : resultScanner) {
                resultList.add(HbaseQueryUtils.buildRowData(hbaseTableEnum.getFamilyName(), result, columnNameList));
            }
            return resultList.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error("hbae select error", e);
            throw new HbaseException(HbaseErrorEnum.DB_CONNECTION_ERROR, e);
        } finally {
            if (table != null) {
                try {
                    table.close();
                } catch (Exception e) {
                    log.error("hbase table close", e);
                }
            }
        }
    }

    /**
     * 创建表
     *
     * @param hbaseTableEnum
     * @throws IOException
     */
    public void creatTable(HbaseTableEnum hbaseTableEnum) {
        Admin admin = null;
        try {
            admin = connection.getAdmin();

            boolean tableExists = admin.tableExists(TableName.valueOf(buildTableName(hbaseTableEnum)));
            if (tableExists) {
                log.warn("tableName is table exists ,tableName:" + buildTableName(hbaseTableEnum));
                return;
            }

            HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(buildTableName(hbaseTableEnum)));
            tableDescriptor.addFamily(new HColumnDescriptor(hbaseTableEnum.getFamilyName()));
            tableDescriptor.setMaxFileSize(hbaseTableEnum.getMaxFileSize());

            admin.createTable(tableDescriptor);
            log.info(" create table is sucess，tableName：" + buildTableName(hbaseTableEnum)
                    + ",maxFileSize:" + hbaseTableEnum.getMaxFileSize()
                    + ",familyName:" + hbaseTableEnum.getFamilyName()
            );
        } catch (Exception e) {
            throw new HbaseException(HbaseErrorEnum.DB_CONNECTION_ERROR, e);
        } finally {
            if (admin != null) {
                try {
                    admin.close();
                } catch (Exception e) {
                    log.error("hbase create table is error ", e);
                }
            }
        }
    }

    /**
     * 创建 nameSpace
     */
    public void createNameSpace() {

        String nameSpace = buildNameSpace();

        if (nameSpace == null) {
            return;
        }

        Admin admin = null;
        try {
            admin = connection.getAdmin();
            // nameSpace 查不到  会直接抛异常，所以这里 只能通过异常来判决 nameSpace 是否存在
            NamespaceDescriptor descriptor = admin.getNamespaceDescriptor(nameSpace);
            if (descriptor != null) {
                return;
            }
        } catch (Exception e) {
        }

        try {
            // 能走到这一步，说明 如果nameSpace 为空  需要创建 nameSpace
            admin.createNamespace(NamespaceDescriptor.create(nameSpace).build());
        } catch (Exception e) {
            throw new HbaseException(HbaseErrorEnum.DB_CONNECTION_ERROR, e);
        } finally {
            if (admin != null) {
                try {
                    admin.close();
                } catch (Exception e) {
                    log.error("hbase create createNameSpace is error ", e);
                }
            }
        }
    }

    private String buildTableName(HbaseTableEnum hbaseTableEnum) {
        String nameSpace = buildNameSpace();
        if (nameSpace == null) {
            return hbaseTableEnum.getTableName();
        } else {
            return tableNameSpace + ":" + hbaseTableEnum.getTableName();
        }
    }

    private String buildNameSpace() {
        // 测试环境默认未设置， 下次优化
        if (StringUtils.isBlank(tableNameSpace)
                || HbbaseConstant.TEST_EVN.equals(tableNameSpace)
                || HbbaseConstant.NULL_EVN.equals(tableNameSpace)) {
            return null;
        }
        return tableNameSpace;
    }


}
