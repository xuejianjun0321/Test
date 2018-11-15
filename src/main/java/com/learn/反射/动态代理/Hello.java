package com.learn.反射.动态代理;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/15 4:37 PM
 */
public class Hello implements IHello {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello" + name);
    }
}
