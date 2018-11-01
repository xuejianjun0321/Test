package com.learn.设计模式.装饰模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 4:20 PM
 */
public class DecoratorTest {

    public static void main(String[] args){
        Sourceable sourceable = new Source();
        Sourceable obj = new Decorator(sourceable);
        obj.method();
    }

}
