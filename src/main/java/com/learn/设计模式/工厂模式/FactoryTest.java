package com.learn.设计模式.工厂模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/29 8:18 PM
 */
public class FactoryTest {

    public static void main(String[] args){

        /** 传参工厂类 */
        SenderFactory factory = new SenderFactory();
        Sender sender = factory.product("mail");
        sender.send();
        sender = factory.product("sms");
        sender.send();

        /**   多方法工厂类      */

        Sender senderMail = factory.produceMail();
        senderMail.send();

        Sender senderSms = factory.produceSma();
        senderSms.send();


        /**  静态方法工厂类 */

        Sender staticMail = SenderFactory.prodeceSMail();
        staticMail.send();

        Sender staticSms = SenderFactory.produceSSms();
        staticSms.send();

    }

}
