package com.learn.设计模式.行为型模式.策略模式;

/**
 * 策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 5:31 PM
 */
public class StrategyTest {

    public static void main(String[] args){
        String exp = "2+8";
        ICalculator calculator = new Plus();
        int result = calculator.calcuate(exp);
        System.out.println(result);
    }

}
