package com.learn.设计模式.观察者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 7:55 PM
 */
public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObserver();
    }
}
