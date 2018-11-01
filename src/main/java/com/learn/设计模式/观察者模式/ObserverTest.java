package com.learn.设计模式.观察者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 7:57 PM
 */
public class ObserverTest {

    public static void main(String[] args){
        Subject subject = new MySubject();
        subject.add(new Observer1());
        subject.add(new Observer2());

        subject.operation();
    }

}
