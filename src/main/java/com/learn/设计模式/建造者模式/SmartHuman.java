package com.learn.设计模式.建造者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/30 3:47 PM
 */
public class SmartHuman implements IBuildHuman {

    Human human;

    public SmartHuman(){
        human = new Human();
    }

    @Override
    public void buildHead() {
      human.setHead("200的智商");
    }

    @Override
    public void buildBody() {
        human.setBody("180的身体");
    }

    @Override
    public void buildHand() {
       human.setHand("手");
    }

    @Override
    public void buildFoot() {
       human.setFoot("脚");
    }

    @Override
    public Human createHuman() {
        return human;
    }
}
