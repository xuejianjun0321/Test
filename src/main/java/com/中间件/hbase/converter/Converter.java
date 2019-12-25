package com.中间件.hbase.converter;

import com.中间件.hbase.annotation.HbaseField;
import com.中间件.hbase.mode.CrmKv;
import com.中间件.hbase.utils.DateUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
        * 数据类型转换器
        * 默认 支持常规数据 byte,short,int long ,double,float,string,Date，LocalDateTime  转换
        */
public interface Converter {

    Set<Class> DEFAULT_CLASS_TYPE_SET = Stream.of(
            Byte.class, byte.class,
            Integer.class, int.class,
            Double.class, double.class,
            Float.class, float.class,
            Long.class, long.class,
            boolean.class, Boolean.class,
            Date.class, LocalDateTime.class,
            String.class
    ).collect(Collectors.toSet());

    /**
     * 将 type 类型 值 转换成 string 值
     *
     * @param field
     * @param entry
     * @return String
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */

    default String convertToString(Field field, Object entry) throws IllegalArgumentException, IllegalAccessException {
        HbaseField hbaseField = field.getAnnotation(HbaseField.class);
        Object value = field.get(entry);
        return convertToString(value, hbaseField);

    }

    /**
     * convertToString
     * @param value
     * @param hbaseField
     * @return
     * @throws IllegalArgumentException
     */
    default String convertToString(Object value, HbaseField hbaseField) throws IllegalArgumentException {

        if (!DEFAULT_CLASS_TYPE_SET.contains(hbaseField.classz())) {
            throw new IllegalArgumentException();
        }


        /**
         * 处理设置 默认值情况
         */
        if(value == null && hbaseField.isRequired()){
            // TODO throw new RuntimeException()
        }

        /**
         * 如果 value
         */
        if (value == null) {
            return null;
        }

        if (String.class == hbaseField.classz()) {
            return (String) value;
        }
        if (Date.class == hbaseField.classz()) {
            return DateUtils.formatDate((Date) value, hbaseField.format().getFormat());
        }
        if (LocalDateTime.class == hbaseField.classz()) {
            return DateUtils.formatLocalDateTime((LocalDateTime) value, hbaseField.format().getFormat());
        }
        return ConvertUtils.convert(value);
    }


    /**
     * 讲 String 值转换成  type 类型值
     * @param field
     * @param rowData
     * @return object
     * @throws ParseException
     */
    default Object convertToObject(Field field, CrmKv<String, Map<String, String>> rowData) throws ParseException {
        HbaseField hbaseField = field.getAnnotation(HbaseField.class);
        if (!DEFAULT_CLASS_TYPE_SET.contains(hbaseField.classz())) {
            throw new IllegalArgumentException();
        }
        String value = rowData.getValue().get(hbaseField.fieldName());
        if (value == null) {
            return null;
        }
        if (String.class == hbaseField.classz()) {
            return value;
        }
        // 解决 非字符串 类型 值 为空情况下 ，赋值异常问题
        if(String.class != hbaseField.classz() && StringUtils.isBlank(value)){
            return null;
        }
        if (Date.class == hbaseField.classz()) {
            return DateUtils.parseDate(value, hbaseField.format().getFormat());
        }
        if (LocalDateTime.class == hbaseField.classz()) {
            return DateUtils.parseLocalDateTime(value, hbaseField.format().getFormat());
        }
        return ConvertUtils.convert(value, hbaseField.classz());
    }
}
