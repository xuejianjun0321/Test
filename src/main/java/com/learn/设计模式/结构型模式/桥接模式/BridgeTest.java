package com.learn.设计模式.结构型模式.桥接模式;

/**
 * 桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化。
 * 桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 4:51 PM
 */
public class BridgeTest {

    public static void main(String[] args){

        Bridge bridge = new MyBridge();

        /** 调用第一个对象 */
        Sourceable sourceable1 = new SourableSub1();
        bridge.setSourceable(sourceable1);
        bridge.method();

        /** 调用第二个对象 */
        Sourceable sourceable2 = new SourceableSub2();
        bridge.setSourceable(sourceable2);
        bridge.method();

    }
}
