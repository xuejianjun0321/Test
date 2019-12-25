package com.中间件.hbase.constant;

/**
 *  查询字段 类型分类
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/18 21:44
 */
public enum  HbaseQueryFieldTypeEnum {
    /**
     * 单个字段
     */
    SINGLE,
    /**
     * 数组类型
     */
    LIST,
    /**
     * 区间类型
     */
    RANGE,
    /**
     * 多个rowKey 筛选
     */
    ROW_KEY_LIST
}
