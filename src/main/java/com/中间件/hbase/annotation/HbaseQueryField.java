package com.中间件.hbase.annotation;


import com.中间件.hbase.constant.HbaseQueryFieldTypeEnum;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.ByteArrayComparable;
import org.apache.hadoop.hbase.filter.CompareFilter;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 *  hbaes query 查询 字段 注解类
 */
public @interface HbaseQueryField {  /**
 * 查询字段分类：支持类型参考
 *  @see HbaseQueryFieldTypeEnum
 *   枚举值：LIST 将会 创建 FilterList 过滤器 直接关系为OR
 *   枚举值：RANGE （区间值）处理 DateRange ，需要设置 rangeCompareOp  ；compareOp 字段作废
 * @return
 */
HbaseQueryFieldTypeEnum fieldType () default  HbaseQueryFieldTypeEnum.SINGLE;

    /**
     * 过滤器顺序
     */
    int sortNum() default 0;

    /**
     * 过滤器 比较器 类型
     * @see CompareFilter.CompareOp
     * @return
     */

    CompareFilter.CompareOp compareOp() default CompareFilter.CompareOp.EQUAL;

    /**
     * 带区间的 比较器 类型  例如 时间区间 DateRange
     * @return
     */
    CompareFilter.CompareOp [] rangeCompareOp() default {};

    /**
     * 比较器
     *
     * @return
     */
    Class<? extends ByteArrayComparable> comparator() default BinaryComparator.class;


    /**
     * 如果不设置为 true，则那些不包含指定 column 的行也会返回
     */
    boolean filterIfMissing() default true;


}
