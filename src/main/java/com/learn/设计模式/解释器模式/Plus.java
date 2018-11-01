package com.learn.设计模式.解释器模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 3:41 PM
 */
public class Plus implements Expression{

    @Override
    public int interpret(Context context) {
        return context.getNum1()+context.getNum2();
    }
}
