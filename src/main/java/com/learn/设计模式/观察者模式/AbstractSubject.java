package com.learn.设计模式.观察者模式;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 5:53 PM
 */
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> observers = new Vector<>();

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void del(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        Enumeration<Observer> enumeration = observers.elements();
        while (enumeration.hasMoreElements()){
            enumeration.nextElement().update();
        }
    }

}
