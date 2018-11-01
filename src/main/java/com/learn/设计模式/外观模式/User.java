package com.learn.设计模式.外观模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 4:43 PM
 */
public class User {

    public static void main(String[] args){

        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();

    }

}
