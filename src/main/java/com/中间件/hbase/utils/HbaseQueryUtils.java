package com.中间件.hbase.utils;


import com.中间件.hbase.annotation.HbaseField;
import com.中间件.hbase.mode.CrmKv;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * hbase query 工具类
 */
public class HbaseQueryUtils {

    /**
     * 获取 entry 所有 数据库存储字段 列名
     *
     * @param entry
     * @return
     */
    public static final String[] getColumnNameLis(Class<?> entry) {
        List<String> columnNameLis = Arrays.stream(entry.getDeclaredFields())
                .filter(f -> f.getAnnotation(HbaseField.class) != null && f.getAnnotation(HbaseField.class).fieldName() != null)
                .map(f -> f.getAnnotation(HbaseField.class).fieldName())
                .collect(Collectors.toList());
        if (columnNameLis == null || columnNameLis.isEmpty()) {
            return null;
        }
        return columnNameLis.toArray(new String[columnNameLis.size()]);
    }

    /**
     * 构建 hbase 行数据
     *
     * @param familyName
     * @param result
     * @param columnNameList
     * @return
     */
    public static CrmKv<String, Map<String, String>> buildRowData(String familyName, Result result, List<String> columnNameList) {
        if (result.getRow() == null) {
            return null;
        }
        String rowKey = Bytes.toString(result.getRow());

        CrmKv<String, Map<String, String>> kv = new CrmKv<>();
        kv.setKey(rowKey);
        if (columnNameList == null) {
            return kv;
        }
        Map<String, String> rowData = new HashMap<>(columnNameList.size());
        columnNameList.stream().forEach(c -> {
            byte[] bytes = result.getValue(Bytes.toBytes(familyName), Bytes.toBytes(c));
            rowData.put(c, bytes != null ? Bytes.toString(bytes) : null);
        });
        kv.setValue(rowData);

        return kv;

    }

    /**
     * 构建 hbase 行数据 列表
     *
     * @param familyName
     * @param resultList
     * @param columnNameList
     * @return
     */
    public static List<CrmKv<String, Map<String, String>>> buildRowDataList(final String familyName,
                                                                            final Result[] resultList, final List<String> columnNameList) {

        return Stream.of(resultList)
                .map(result -> buildRowData(familyName, result, columnNameList))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


}
