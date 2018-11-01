package com.learn.设计模式.适配器模式.类的适配器;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 11:38 AM
 */
public class AdapterTest {

    public static void main(String[] args){
        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();
    }

}
