package com.learn.设计模式.代理模式;

/**
 *
 * 如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法：

 1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。

 2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。

 使用代理模式，可以将功能划分的更加清晰，有助于后期维护！


 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 4:30 PM
 */
public class Test {

    public static void main(String[] args){
        Sourceable sourceable = new Proxy();
        sourceable.method();
    }

}
