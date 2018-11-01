package com.learn.设计模式.工程方法模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/29 8:39 PM
 */
public  class Test {

    public static void main(String [] args){
        Provider provider = new MailSenderFactory();
        Sender sender = provider.prodece();
        sender.sender();
        System.out.println("*************************");

        /** 抽象工厂模式 */
        Sender smsSender =new FirstSmsFactory().procduceSms();
        smsSender.sender();

    }

}
