package com.中间件.hbase.utils;


import com.中间件.hbase.annotation.HbaseQueryField;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * hbase 筛选 比较器，常用方法
 */
public class ByteArrayComparableUtils {

    /**
     * 构建列比较器
     *
     * @param value
     * @param hbaseQueryField
     * @return
     * @throws NullPointerException
     */
    public static final ByteArrayComparable buildByteArrayComparable(String value, HbaseQueryField hbaseQueryField) throws NullPointerException {
        return buildByteArrayComparable(value, hbaseQueryField.comparator());
    }

    /**
     * 构建列比较器
     *
     * @param value
     * @param comparator
     * @return
     * @throws NullPointerException
     */
    public static final ByteArrayComparable buildByteArrayComparable(String value, Class<? extends ByteArrayComparable> comparator) throws NullPointerException {

        if (value == null && NullComparator.class == comparator) {
            return new NullComparator();
        }
        if (value == null) {
            // TODO
            throw new NullPointerException("请明确查询条件 比较器");
        }
        if (SubstringComparator.class == comparator) {
            return new SubstringComparator(value);
        }
        if (BinaryComparator.class == comparator) {
            return new BinaryComparator(Bytes.toBytes(value));
        }
        if (BinaryPrefixComparator.class == comparator) {
            return new BinaryPrefixComparator(Bytes.toBytes(value));
        }

        if (RegexStringComparator.class == comparator) {
            return new RegexStringComparator(value);
        }
        throw new NullPointerException("请明确查询条件 比较器 ");
    }

}
