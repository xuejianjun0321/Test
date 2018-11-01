package com.learn.设计模式.创建型模式.建造者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/30 3:45 PM
 */
public interface IBuildHuman {

    void buildHead();

    void buildBody();

    void buildHand();

    void buildFoot();

    Human createHuman();

}
