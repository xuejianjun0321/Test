package com.learn.设计模式.备忘录模式;

/**
 * 主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 2:30 PM
 */
public class Test {

    public static void main(String[] args){
        //创建原始类
        Original original = new Original("egg");

        //创建备忘录
        Storage storage = new Storage(original.createMemento());

        //修改原始类的状态
        System.out.println("初始化的状态为：" + original.getValue());
        original.setValue("niu");
        System.out.println("修改后的状态为：" + original.getValue());

        //回复原始类的状态
        original.restoreMemento(storage.getMemento());
        System.out.println("恢复后的状态为：" + original.getValue());
    }

}
