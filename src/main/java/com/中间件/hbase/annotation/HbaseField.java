package com.中间件.hbase.annotation;

import com.中间件.hbase.constant.HbaseFieldDefaultValueEnum;
import com.中间件.hbase.constant.HbaseFieldformatEnum;

import java.lang.annotation.*;

/**
 * hbase 列字段 注解
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/18 21:18
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface HbaseField {

    /**
     * hbase 表里字段名称
     * @return
     */
    String fieldName() default "";

    /**
     * 目标数据类型
     * @return
     */
    Class<?> classz() default String.class;

    /**
     * 格式化参数 例如 日期格式化 字符串
     * @return
     */
    HbaseFieldformatEnum format() default HbaseFieldformatEnum.NULL ;

    /**
     * 默认值
     * @return
     */
    HbaseFieldDefaultValueEnum defaultValue() default HbaseFieldDefaultValueEnum.NULL;

    /**
     * 必
     * @return
     */
    boolean isRequired() default false;


}
