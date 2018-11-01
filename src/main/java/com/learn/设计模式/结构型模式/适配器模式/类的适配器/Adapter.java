package com.learn.设计模式.结构型模式.适配器模式.类的适配器;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 11:37 AM
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
