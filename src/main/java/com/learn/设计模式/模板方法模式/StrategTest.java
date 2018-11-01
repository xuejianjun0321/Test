package com.learn.设计模式.模板方法模式;

/**
 * 解释一下模板方法模式，就是指：一个抽象类中，有一个主方法，再定义1...n个方法，可以是抽象的，也可以是实际的方法，定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 5:41 PM
 */
public class StrategTest {

    public static void main(String[] args){
        String exp ="9+9";

        AbstractCaluclator caluclator = new Plus();
        int result = caluclator.calculate(exp,"\\+");
        System.out.println(result);

    }

}
