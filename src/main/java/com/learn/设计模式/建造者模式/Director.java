package com.learn.设计模式.建造者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/30 4:21 PM
 */
public class Director {

    public Human createHumanByDirector(IBuildHuman iBuildHuman){
        iBuildHuman.buildBody();
        iBuildHuman.buildHand();
        iBuildHuman.buildHead();
        iBuildHuman.buildFoot();
        return iBuildHuman.createHuman();
    }

}
