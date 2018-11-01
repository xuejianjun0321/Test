package com.learn.设计模式.结构型模式.桥接模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 4:47 PM
 */
public class SourableSub1 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is first Sub");
    }
}
