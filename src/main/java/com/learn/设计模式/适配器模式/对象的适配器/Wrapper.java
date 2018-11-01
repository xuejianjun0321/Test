package com.learn.设计模式.适配器模式.对象的适配器;

import com.learn.设计模式.适配器模式.类的适配器.Source;
import com.learn.设计模式.适配器模式.类的适配器.Targetable;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 11:41 AM
 */
public class Wrapper implements Targetable {

    private Source source;


    public Wrapper(Source source){
        super();
        this.source = source;
    }


    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is targetable metchod!");
    }

}
