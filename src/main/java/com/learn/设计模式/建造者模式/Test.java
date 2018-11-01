package com.learn.设计模式.建造者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/30 4:22 PM
 */
public class Test {

    public static void main(String[] args){
        Director director = new Director();
        Human human = director.createHumanByDirector(new  SmartHuman());
        System.out.println(human.getBody());
        System.out.println(human.getFoot());
        System.out.println(human.getHead());
        System.out.println(human.getHand());
    }

}
