package com.中间件.hbase.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 时间工具类
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/18 21:20
 */
public class DateUtils {

    public static final Map<String, DateTimeFormatter> SIMPLE_DATE_FORMAT_MAP = new ConcurrentHashMap<>();

    public static final String DEFULT_FORMAT_STR = "dd/MM/yyyy HH:mm:ss";

    public static final String NEW_FORMAT_STR = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_Y_M_D="yyyyMMdd";

    public static String formatDate(Date date, String formatStr) {
        return new SimpleDateFormat(formatStr).format(date);
    }

    public static Date parseDate(String dateStr, String formatStr) throws ParseException {
        return new SimpleDateFormat(formatStr).parse(dateStr);
    }

    public static String formatLocalDateTime(LocalDateTime localDateTime, String formatStr) {
        if(localDateTime == null){
            return "";
        }
        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(formatStr);
        return localDateTime.format(dateTimeFormatter);
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String formatStr) {
        if(StringUtils.isBlank(dateTimeStr)){
            return null;
        }
        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(formatStr);
        return LocalDateTime.parse  (dateTimeStr,dateTimeFormatter);
    }

    public static DateTimeFormatter getDateTimeFormatter(String formatStr) {

        DateTimeFormatter dateTimeFormatter = SIMPLE_DATE_FORMAT_MAP.get(formatStr);
        if (dateTimeFormatter == null) {
            dateTimeFormatter = DateTimeFormatter.ofPattern(formatStr);
            SIMPLE_DATE_FORMAT_MAP.put(formatStr, dateTimeFormatter);
        }
        return dateTimeFormatter;
    }

    /**
     * 将时间转换成毫秒数
     * @param localDateTime
     * @return
     */
    public static long getTime(LocalDateTime localDateTime){
        TimeZone timeZone =TimeZone.getDefault();
        ZoneOffset defaultZoneOffset = ZoneOffset.ofTotalSeconds( timeZone.getRawOffset()/1000);
        long time =localDateTime.toEpochSecond(defaultZoneOffset);
        return time;
    }

}
