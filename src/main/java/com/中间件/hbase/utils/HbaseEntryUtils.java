package com.中间件.hbase.utils;


import com.中间件.hbase.annotation.HbaseField;
import com.中间件.hbase.constant.HbaseFieldDefaultValueEnum;

import java.lang.reflect.Field;

/**
 * hbaser 实体操作util
 */
public class HbaseEntryUtils {

    /**
     * hbaseEntry 设置默认值
     * @param entry
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setDefaultValue(Object entry)throws  IllegalArgumentException,IllegalAccessException{
        for (Field field : entry.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            HbaseField hbaseField = field.getAnnotation(HbaseField.class);
            if (hbaseField == null) {
                continue;
            }
            Object value = field.get(entry);
            if (value == null && hbaseField.defaultValue() != HbaseFieldDefaultValueEnum.NULL) {
                field.set(entry, hbaseField.defaultValue().getSupplier().get());
            }
        }
    }
}
