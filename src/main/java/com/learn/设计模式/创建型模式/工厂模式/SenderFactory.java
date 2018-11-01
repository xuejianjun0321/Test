package com.learn.设计模式.创建型模式.工厂模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/29 8:15 PM
 */
public class SenderFactory {

    /**
     * 传类型去创建相关产品
     * @param type 类型
     * @return 产品
     */
    public Sender product(String type){
        if ("mail".equals(type)){
            return new MailSender();
        }else if ("sms".equals(type)){
            return new SmsSender();
        }else {
            System.out.println("请输入正确的类型");
            return null;
        }
    }

    /**   多方法工厂类      */

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSma(){
        return new SmsSender();
    }

    /**  静态方法工厂类 */

    public static Sender prodeceSMail(){
        return new MailSender();
    }

    public static Sender produceSSms(){
        return new SmsSender();
    }

}
