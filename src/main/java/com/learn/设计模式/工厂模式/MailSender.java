package com.learn.设计模式.工厂模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/29 8:13 PM
 */
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is  mailSender!");
    }
}
