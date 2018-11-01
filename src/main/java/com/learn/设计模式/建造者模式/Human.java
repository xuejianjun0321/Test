package com.learn.设计模式.建造者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/30 3:43 PM
 */
public class Human {

   private String head;

   private String body;

   private String hand;

   private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String handd) {
        this.hand = handd;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
