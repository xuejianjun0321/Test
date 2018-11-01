package com.learn.设计模式.中介者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 3:29 PM
 */
public class MyMediator implements Mediator {

    private User1 user1;

    private User2 user2;

    @Override
    public void createMediator() {
       user1 = new User1(this);
       user2 = new User2(this);
    }

    @Override
    public void woekAll() {
        user1.work();
        user2.work();
    }
}
