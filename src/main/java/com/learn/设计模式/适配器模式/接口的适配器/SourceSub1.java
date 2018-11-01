package com.learn.设计模式.适配器模式.接口的适配器;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 11:49 AM
 */
public class SourceSub1 extends Wrapper2 {

    public void method1(){
        System.out.println("this sourceable interface`s first Sub1");
    }

}
