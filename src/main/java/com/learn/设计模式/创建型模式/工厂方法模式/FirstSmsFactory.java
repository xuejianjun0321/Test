package com.learn.设计模式.创建型模式.工厂方法模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/29 8:48 PM
 */
public class FirstSmsFactory extends AbstractFactory {


    @Override
    public Sender procduceSms() {
        Provider provider = new SmsSenderFactory();
        Sender sender = provider.prodece();
        return sender;
    }

}
