package com.learn.设计模式.行为型模式.备忘录模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 2:27 PM
 */
public class Memento {

    private String value;

    public Memento(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
