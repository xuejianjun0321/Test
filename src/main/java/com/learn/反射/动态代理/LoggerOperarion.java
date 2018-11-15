package com.learn.反射.动态代理;

import java.lang.reflect.Method;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/15 4:12 PM
 */
public class LoggerOperarion implements IOperation {
    @Override
    public void start(Method method) {
        System.out.println();
        System.out.println("****************************start****************************");
        Logger.logging(Level.DEBUGE,method.getName() + "Method start.");
    }

    @Override
    public void end(Method method) {
        Logger.logging(Level.INFO,method.getName() +"Method end.");
        System.out.println("****************************end****************************");
    }
}
