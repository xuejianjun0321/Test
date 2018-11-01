package com.learn.设计模式.结构型模式.代理模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 4:26 PM
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("this original method!");
    }
}
