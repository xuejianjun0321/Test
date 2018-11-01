package com.learn.设计模式.行为型模式.迭代子模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 8:03 PM
 */
public interface Collection {

    Iterator iterator();

    /** 取得集合元素 */
    Object get(int i);

    /** 取得集合大小 */
    int size();

}
