package com.learn.设计模式.工程方法模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/29 8:37 PM
 */
public class MailSenderFactory implements  Provider {
    @Override
    public Sender prodece() {
        return new MailSender();
    }
}
