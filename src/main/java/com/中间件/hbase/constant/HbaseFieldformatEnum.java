package com.中间件.hbase.constant;

import com.中间件.hbase.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

/**
 * hbase 表字段 复杂类型 format
 */
public enum HbaseFieldformatEnum {
    /**
     * 默认值 ：
     */
    NULL(null),
    /**
     * 日期类型 默认转换
     */
    DEFAULT_DATE_FORMAT(DateUtils.NEW_FORMAT_STR),

    /**
     * 日期转换类型 yyyyMMdd
     */
    DATE_FORMAT_Y_M_D(DateUtils.DATE_FORMAT_Y_M_D);

    private String format;
}
