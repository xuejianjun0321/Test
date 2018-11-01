package com.learn.设计模式.观察者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 5:50 PM
 */
public class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("observer1 has recceived!");
    }
}
