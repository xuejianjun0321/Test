package com.中间件.hbase.repository.impl;


import com.中间件.hbase.constant.CommonResultEnum;
import com.中间件.hbase.constant.HbaseErrorEnum;
import com.中间件.hbase.constant.HbaseTableEnum;
import com.中间件.hbase.exceptions.HbaseException;
import com.中间件.hbase.exceptions.RestServiceException;
import com.中间件.hbase.mode.ClueQuery;
import com.中间件.hbase.mode.CrmKv;
import com.中间件.hbase.mode.HbasePageResult;
import com.中间件.hbase.repo.HbaseRepo;
import com.中间件.hbase.repository.ClueRepository;
import com.中间件.hbase.repository.entity.Clue;
import com.中间件.hbase.repository.entity.ClueUtils;
import com.中间件.hbase.repository.entity.HbasePageDataResult;
import com.中间件.hbase.repository.entity.RowkeyRange;
import com.中间件.hbase.utils.HbaseQueryUtils;
import com.中间件.hbase.utils.PageQuery;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 线索相关hbase 操作
 */
@Repository
@Slf4j
public class ClueHbaseRepository implements ClueRepository {

    @Setter
    @Resource
    private HbaseRepo hbaseRepo;

    @Override
    public Clue insertClue(Clue clue) {
        try {
            //适配省市信息

            CrmKv<String, Map<String, String>> rowData = clue.buildRowData();
            hbaseRepo.insert(HbaseTableEnum.TABLE_CLUE_INFO, rowData);
            // 发送MQ消息
            return clue;
        } catch (RestServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("insertClue error", e);
            throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
        }
    }

    @Override
    public Clue updateClue(String rowKey, Function<Clue, Clue> updateFunction) {
        if (updateFunction == null) {
            throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR,
                    "更新线索方法异常，更新线索函数不可为空");
        }

        try {

            Clue oldClue = findByRowKey(rowKey);
            if (oldClue == null) {
                throw new HbaseException(HbaseErrorEnum.DATA_IS_NULL_ERROR);
            }
            Clue clue = updateFunction.apply(oldClue);
            clue.setModifyDate(LocalDateTime.now());
            //适配省市信息

            clue.setIsModifyAddr(oldClue.getIsModifyAddr());
            try {
                CrmKv<String, Map<String, String>> rowData = clue.buildRowData();
                hbaseRepo.update(HbaseTableEnum.TABLE_CLUE_INFO, rowKey, rowData);

                return clue;
            } catch (RestServiceException e) {
                throw e;
            } catch (Exception e) {
                log.error("updateClue is error", e);
                throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
            }
        } finally {

        }
    }

    @Override
    public Clue updateClueByDataId(String dataId, Function<Clue, Clue> updateFunction) {
        String rowKey = ClueUtils.buildRowKeyByDataId(dataId);

        try {

            Clue oldClue = findByDataId(dataId);
            if (oldClue == null) {
                throw new HbaseException(HbaseErrorEnum.DATA_IS_NULL_ERROR);
            }
            Clue clue = updateFunction.apply(oldClue);
            clue.setModifyDate(LocalDateTime.now());
            try {
                CrmKv<String, Map<String, String>> rowData = clue.buildRowData();
                hbaseRepo.update(HbaseTableEnum.TABLE_CLUE_INFO, oldClue.getRowKey(), rowData);

                return clue;
            } catch (RestServiceException e) {
                throw e;
            } catch (Exception e) {
                log.error("updateClueByDataId is error", e);
                throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
            }
        } finally {

        }
    }


    @Override
    public Clue findByRowKey(String rowKey) {
        if (StringUtils.isEmpty(rowKey)) {
            return null;
        }
        String[] columnNameLis = HbaseQueryUtils.getColumnNameLis(Clue.class);
        try {
            CrmKv<String, Map<String, String>> kv = hbaseRepo.get(HbaseTableEnum.TABLE_CLUE_INFO, rowKey, Arrays.asList(columnNameLis));
            if (kv == null || MapUtils.isEmpty(kv.getValue())) {
                return null;
            }
            Clue clue = (Clue) new Clue().buildEntry(kv);
            return clue;
        } catch (RestServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("findByRowKey is error", e);
            throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
        }

    }

    /**
     * 根据 dataid 查询 线索
     *
     * @param dataId
     * @return
     */
    @Override
    public Clue findByDataId(String dataId) {
        if (StringUtils.isBlank(dataId)) {
            return null;
        }
        String rowKey;
        try {
            rowKey = ClueUtils.buildRowKeyByDataId(dataId);
        } catch (RestServiceException re) {
            log.info("{}-dataId查询线索失败：{}", Thread.currentThread().getName(), re);
            return null;
        }
        try {
            return findByRowKey(rowKey);
        } catch (RestServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("findByDataId error", e);
            throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
        }
    }


    @Override
    public List<Clue> findByRowKeys(List<String> rowKeyList) {
        if (rowKeyList == null || rowKeyList.isEmpty()) {
            return new ArrayList<>(0);
        }
        String[] columnNameLis = HbaseQueryUtils.getColumnNameLis(Clue.class);
        try {
            List<CrmKv<String, Map<String, String>>> rowDataList = hbaseRepo.getList(HbaseTableEnum.TABLE_CLUE_INFO, rowKeyList, Arrays.asList(columnNameLis));
            List clues = ClueUtils.rowDataToEntry(rowDataList);
            return clues;
        } catch (RestServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("findByRowKeys is error", e);
            throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
        }
    }


    public long count(ClueQuery clueQuery) {
        try {
            Scan scan = clueQuery.buildScan(false);
            List<CrmKv<String, Map<String, String>>> rowDataList = hbaseRepo.select(HbaseTableEnum.TABLE_CLUE_INFO, scan, null);
            List<Clue> list = ClueUtils.rowDataToEntry(rowDataList);
            return list.size();
        } catch (Exception e) {
            log.error("count error", e);
            throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
        }
    }


    /**
     * 查询所有的线索
     *
     * @param clueQuery
     * @return
     */
    @Override
    public List<Clue> findAll(ClueQuery clueQuery) {
        try {
            Scan scan = clueQuery.buildScan(false);
            List<CrmKv<String, Map<String, String>>> rowDataList = hbaseRepo.select(HbaseTableEnum.TABLE_CLUE_INFO, scan, null);
            List<Clue> list = ClueUtils.rowDataToEntry(rowDataList);
            return list;
        } catch (Exception e) {
            log.error("count error", e);
            throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
        }
    }

    /**
     * 获取分页数据
     *
     * @param clueQuery
     * @return
     */
    public HbasePageDataResult selectCluePage(ClueQuery clueQuery) {
        try {
            Scan scan = clueQuery.buildScan(false);
            List<CrmKv<String, Map<String, String>>> rowDataList = hbaseRepo.select(HbaseTableEnum.TABLE_CLUE_INFO, scan, null);
            List<Clue> list = ClueUtils.rowDataToEntry(rowDataList);
            HbasePageDataResult result = new HbasePageDataResult();
            result.setTotalRows(list.size());
            int pageSize = clueQuery.getPage().getPageSize();
            if (list.isEmpty()) {
                result.setData(new ArrayList<>(0));
                return result;
            }

            int totalPages = list.size() % pageSize == 0 ? list.size() / pageSize : list.size() / pageSize + 1;
            List<List<Clue>> pageList = new ArrayList<>();
            for (int i = 0; i < totalPages; i++) {
                if ((i + 1) != totalPages || list.size() % pageSize == 0) {
                    pageList.add(list.subList(i * pageSize, (i + 1) * pageSize));
                } else {
                    pageList.add(list.subList(i * pageSize, list.size()));
                }
            }

            List<RowkeyRange> data = pageList.stream()
                    .map(subList -> new RowkeyRange(subList.get(0).getRowKey(), subList.get(subList.size() - 1).getRowKey()))
                    .collect(Collectors.toList());

            result.setData(data);
            result.setPageSize(clueQuery.getPage().getPageSize());
            return result;

        } catch (RestServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("selectCluePage error", e);
            throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
        }
    }

    /**
     * 分页查询
     */
    @Override
    public HbasePageResult<Clue> selectClueList(ClueQuery query) {
        try {
            Scan scan = query.buildScan(true);
            String[] columnNameLis = HbaseQueryUtils.getColumnNameLis(Clue.class);
            List<CrmKv<String, Map<String, String>>> rowDataList = hbaseRepo.select(HbaseTableEnum.TABLE_CLUE_INFO, scan, Arrays.asList(columnNameLis));
            List<Clue> list = ClueUtils.rowDataToEntry(rowDataList);
            int pageSize = query.getPage().getPageSize();
            String nextRowKey = CollectionUtils.isNotEmpty(list) && list.size() > pageSize && list.get(pageSize) != null ? list.get(pageSize).getRowKey() : null;
            boolean hasNext = nextRowKey != null;
            List<Clue> data = hasNext ? list.subList(0, pageSize - 1) : list;
            HbasePageResult pageResult = new HbasePageResult(pageSize, nextRowKey, hasNext, data);
            return pageResult;
        } catch (RestServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("selectClueList ", e);
            throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
        }
    }

    @Override
    public void removeClue(List<String> clueId) {
        try {
            hbaseRepo.delete(HbaseTableEnum.TABLE_CLUE_INFO, clueId);

        } catch (RestServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("removeClue ", e);
            throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
        }
    }

    @Override
    public List<Clue> findByOuid(List<String> ouidList) {
        if (ouidList == null || ouidList.isEmpty()) {
            return new ArrayList<>(0);
        }

        List<Filter> subFilter = ouidList.stream()
                .filter(Objects::nonNull)
                .map(ouid -> new SingleColumnValueFilter(
                        HbaseTableEnum.TABLE_CLUE_INFO.getFamilyName().getBytes(),
                        "ouid".getBytes(),
                        CompareFilter.CompareOp.EQUAL,
                        Bytes.toBytes(ouid))
                ).collect(Collectors.toList());

        if (subFilter.isEmpty()) {
            return new ArrayList<>(0);
        }

        Scan scan = new Scan();
        FilterList rootFilterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
        scan.setFilter(rootFilterList);
        rootFilterList.addFilter(new FilterList(FilterList.Operator.MUST_PASS_ONE, subFilter));

        try {
            String[] columnNameLis = HbaseQueryUtils.getColumnNameLis(Clue.class);
            List<CrmKv<String, Map<String, String>>> rowDataList = hbaseRepo.select(HbaseTableEnum.TABLE_CLUE_INFO, scan, Arrays.asList(columnNameLis));
            if (rowDataList == null || rowDataList.isEmpty()) {
                return new ArrayList<>(0);
            }
            List<Clue> clues = ClueUtils.rowDataToEntry(rowDataList);
            return clues;
        } catch (RestServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("findByOuid error", e);
            throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
        }
    }


    public void createTable() {
        hbaseRepo.createNameSpace();
        hbaseRepo.creatTable(HbaseTableEnum.TABLE_CLUE_INFO);
    }

    /**
     * 查询所有数据，方便比较
     *
     * @return
     */
    @Deprecated
    public HbasePageResult<Clue> selectClueAll() {

        ClueQuery clueQuery = new ClueQuery();
        clueQuery.setPage(new PageQuery());
        clueQuery.getPage().setPageSize(Integer.MAX_VALUE);
        try {
            HbasePageResult<Clue> searchList = selectClueList(clueQuery);
            return searchList;
        } catch (RestServiceException e) {
            throw e;
        } catch (Exception e) {
            log.error("selectClueAll error", e);
            throw new RestServiceException(CommonResultEnum.SERVER_TEMPLATE_ERR, e);
        }

    }


}
