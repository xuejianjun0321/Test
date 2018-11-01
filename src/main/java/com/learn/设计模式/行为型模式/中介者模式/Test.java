package com.learn.设计模式.行为型模式.中介者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 3:37 PM
 */
public class Test {

    public static void main(String[] args){
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.woekAll();
    }

}
