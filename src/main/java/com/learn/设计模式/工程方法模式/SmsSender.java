package com.learn.设计模式.工程方法模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/29 8:35 PM
 */
public class SmsSender implements Sender {
    @Override
    public void sender() {
        System.out.println("this is smsSender!");
    }
}
