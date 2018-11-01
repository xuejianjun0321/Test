package com.learn.设计模式.行为型模式.备忘录模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 2:29 PM
 */
public class Storage {

    private Memento memento;

    public Storage(Memento memento){
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
