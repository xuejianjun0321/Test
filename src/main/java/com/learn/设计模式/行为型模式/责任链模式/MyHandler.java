package com.learn.设计模式.行为型模式.责任链模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 8:24 PM
 */
public class MyHandler extends AbstractHandler implements Handler {

    private String name;


    public MyHandler(String name){
        this.name =name;
    }

    @Override
    public void operator() {
        System.out.println(name + "deal!");
        if (getHandler()!=null){
            getHandler().operator();
        }

    }
}
