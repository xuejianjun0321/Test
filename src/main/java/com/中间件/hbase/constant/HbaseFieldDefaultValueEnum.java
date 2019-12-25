package com.中间件.hbase.constant;

import com.中间件.hbase.mode.DateRange;
import com.中间件.hbase.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.function.Supplier;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/18 21:24
 */
@Getter
@AllArgsConstructor
public enum HbaseFieldDefaultValueEnum {

    /**
     * 查询字段 默认值
     */
    NULL(() -> null),

    /**
     * 字符串
     */
    STRING_VALUE(() -> ""),

    BYTE_VALUE(() -> Byte.valueOf((byte) 0)),

    BOOLEN_VALUE(() -> false),

    DEFAULT_DATE(() -> LocalDateTime.now()),

//    DEFAUT_TRACE_ID(() -> {
//        long sand = Sahara.instance.getSand();
//        String dateStr = DateUtils.formatLocalDateTime(LocalDateTime.now(), DateUtils.NEW_FORMAT_STR);
//        return dateStr + sand;
//    }),

    DATE_RANGE_VALUE(() -> {
        DateRange dateRange = new DateRange();
        return dateRange;
    }),

    DEFAULT_PRODUCT_INTENTION(()->{
        return ProductIntentionEnum.NULL.getCode();
    });
    private Supplier<? extends Object> supplier;

}
