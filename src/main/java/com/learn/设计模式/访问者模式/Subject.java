package com.learn.设计模式.访问者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 3:18 PM
 */
public interface Subject {

    void accept(Visitor visitor);

    String getSubject();

}
