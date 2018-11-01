package com.learn.设计模式.创建型模式.工厂方法模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/29 8:38 PM
 */
public class SmsSenderFactory implements Provider {
    @Override
    public Sender prodece() {
        return new SmsSender();
    }
}
