package com.learn.反射.动态代理;

/**
 * 方法前去加上一条日志记录
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/15 4:36 PM
 */
public class Test {

    public static void main(String[] args){
        IHello hello = (IHello) new DynaProxyHello().bind(new Hello(),new LoggerOperarion());
        hello.sayHello("Xjun");
    }

}
