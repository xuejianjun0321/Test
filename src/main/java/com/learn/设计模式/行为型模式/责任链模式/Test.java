package com.learn.设计模式.行为型模式.责任链模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 8:27 PM
 */
public class Test {

    public static void main(String[] args){
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");
        h1.setHandler(h2);
        h2.setHandler(h3);

        h1.operator();

    }

}
