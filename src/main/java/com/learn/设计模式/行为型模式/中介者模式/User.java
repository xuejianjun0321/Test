package com.learn.设计模式.行为型模式.中介者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 3:29 PM
 */
public abstract class User {

    private Mediator mediator;

    public abstract void  work();

    public User(Mediator mediator){
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }


}
