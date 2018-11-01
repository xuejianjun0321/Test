package com.learn.设计模式.行为型模式.模板方法模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 5:40 PM
 */
public class Plus extends AbstractCaluclator {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
