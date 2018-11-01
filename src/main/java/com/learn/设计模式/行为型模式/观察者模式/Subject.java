package com.learn.设计模式.行为型模式.观察者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 5:51 PM
 */
public interface Subject {

    /** 增加观察者 */
    void add(Observer observer);

    /** 删除观察者 */
    void del(Observer observer);

    /** 通知所有观察者 */
    void notifyObserver();

    /** 自身的操作 */
    void operation();
}
