package com.learn.设计模式.中介者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 3:33 PM
 */
public class User1 extends User {


    public User1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user1 exe!");
    }
}
