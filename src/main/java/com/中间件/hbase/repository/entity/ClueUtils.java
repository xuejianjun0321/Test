package com.中间件.hbase.repository.entity;


import com.中间件.hbase.exceptions.RestServiceException;
import com.中间件.hbase.mode.CrmKv;
import com.中间件.hbase.utils.DateUtils;
import lombok.NonNull;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author
 * 线索 实体辅助工具类
 */
public class ClueUtils {

    static String ROW_KEY_PATTERN = "{0}_{1}";

    public static final MessageFormat ROW_KEY_MESSAGE_FORMAT = new MessageFormat(ROW_KEY_PATTERN);

    /**
     * 生成rowkey
     *
     * @return
     */

    public static String createRowKey(Clue clue) {

        String createDate = DateUtils.formatLocalDateTime(clue.getCreateDate(), DateUtils.NEW_FORMAT_STR);
        return buildRowKey(createDate, "");


    }

    /**
     * 构建 rowkey
     *
     * @param time
     * @param id
     * @return
     */
    public static String buildRowKey(String time, String id) {
        return ROW_KEY_MESSAGE_FORMAT.format(new Object[]{time, id});
    }

    /**
     * 构建 通过 data id 反向算 rowkey
     *
     * @param dataId
     * @return
     */
    public static String buildRowKeyByDataId(@NonNull String dataId) {

        // 构建rowkey
        if (dataId.length() <= DateUtils.NEW_FORMAT_STR.length()) {
            throw new RestServiceException("data id 格式不正确");
        }
        String time = dataId.substring(0, DateUtils.NEW_FORMAT_STR.length());
        return buildRowKey(time, dataId);
    }

    public static Clue rowDataToEntry(CrmKv<String, Map<String, String>> rowData) throws IllegalArgumentException, IllegalAccessException, ParseException {
        if (rowData == null) {
            return null;
        }
        Clue clue = new Clue();
        clue.buildEntry(rowData);
        return clue;
    }

    public static List<Clue> rowDataToEntry(List<CrmKv<String, Map<String, String>>> rowDataList) throws IllegalArgumentException, IllegalAccessException, ParseException {
        if (rowDataList == null || rowDataList.isEmpty()) {
            return new ArrayList<>(0);
        }
        List<Clue> clues = new ArrayList<>(rowDataList.size());
        for (CrmKv<String, Map<String, String>> row : rowDataList) {
            if (row != null && row.getKey() != null) {
                clues.add(rowDataToEntry(row));
            }
        }
        return clues;
    }
}
