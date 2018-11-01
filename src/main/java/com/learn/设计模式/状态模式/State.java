package com.learn.设计模式.状态模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 2:58 PM
 */
public class State {

    private String value;

    public void method1(){
        System.out.println("execute the first opt!");
    }

    public void method2(){
        System.out.println("execte the send opt!");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}