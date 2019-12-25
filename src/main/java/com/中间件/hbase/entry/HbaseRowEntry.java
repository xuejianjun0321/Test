package com.中间件.hbase.entry;

import com.中间件.hbase.annotation.HbaseField;
import com.中间件.hbase.converter.Converter;
import com.中间件.hbase.exceptions.RestServiceException;
import com.中间件.hbase.mode.CrmKv;
import com.中间件.hbase.utils.HbaseEntryUtils;
import lombok.NonNull;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/18 21:45
 */
public interface HbaseRowEntry {

    /**
     * 获取 rowKey
     *
     * @return
     */
    String getRowKey();

    /**
     *设置rowkey
     * @param string
     */
    void setRowKey(String string);

    /**
     * 获取转换器
     *
     * @return
     */
    Converter getConverter();

    /**
     * hbase 行实体 ，转换成hbase 行数据
     * @return
     * @throws IllegalAccessException
     */
    default CrmKv<String, Map<String, String>> buildRowData() throws IllegalAccessException {
        CrmKv<String, Map<String, String>> kv = new CrmKv<>();
        kv.setKey(getRowKey());
        kv.setValue(new HashMap<>(16));
        for (Field f : this.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            HbaseField hbaseField = f.getAnnotation(HbaseField.class);
            if (hbaseField != null) {
                String value = getConverter().convertToString(f, this);
                kv.getValue().put(hbaseField.fieldName(), value);
            }
        }
        return kv;
    }

    /**
     * 使用 hbase 行数据  ，填充hbase 行实体
     *
     * @param rowData
     * @return HbaseRowEntry
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws ParseException
     */
    default HbaseRowEntry buildEntry( @NonNull CrmKv<String, Map<String, String>> rowData) throws IllegalArgumentException, IllegalAccessException, ParseException {
        Converter converter = getConverter();
        setRowKey(rowData.getKey());
        if (rowData.getValue() ==null){
            return this;
        }
        for (Field field : this.getClass().getDeclaredFields()) {
            HbaseField hbaseField = field.getAnnotation(HbaseField.class);
            field.setAccessible(true);
            if (hbaseField == null) {
                continue;
            }

            Object objectValue = field.get(this);
            if (objectValue == null && hbaseField.isRequired()) {
                throw new RestServiceException("必填字段未填写");
            }
            Object value = converter.convertToObject(field, rowData);
            field.set(this, value);
        }
        return this;
    }

    /**
     * 默认值设置
     *
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    default void setDefaultValue() throws IllegalArgumentException, IllegalAccessException {
        HbaseEntryUtils.setDefaultValue(this);
    }



}
