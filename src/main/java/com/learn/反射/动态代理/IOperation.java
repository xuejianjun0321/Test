package com.learn.反射.动态代理;

import java.lang.reflect.Method;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/15 4:10 PM
 */
public interface IOperation {

    /**
     * 方法执行前的操作
     * @param method method
     */
    void start(Method method);

    /**
     * 方法执行后的操作
     * @param method method
     */
    void end(Method method);
}
