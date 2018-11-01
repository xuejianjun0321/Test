package com.learn.设计模式.行为型模式.策略模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 5:30 PM
 */
public class Minus extends AbstractCalculator implements  ICalculator {
    @Override
    public int calcuate(String exp) {
        int arrayInt[] = split(exp,"\\-");
        return arrayInt[0] - arrayInt[1];
    }
}
