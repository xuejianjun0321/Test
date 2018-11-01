package com.learn.设计模式.代理模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 4:28 PM
 */
public class Proxy implements Sourceable {

    private Source source;

    public Proxy(){
        super();
        this.source = new Source();
    }

    @Override
    public void method() {

        after();
        source.method();
        before();

    }


    private void after(){
        System.out.println("after porxy");
    }

    private void before(){
        System.out.println("before porxy");
    }

}
