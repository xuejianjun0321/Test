package com.learn.设计模式.桥接模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 4:50 PM
 */
public class MyBridge extends Bridge {

    public void method(){
        getSourceable().method();
    }

}
