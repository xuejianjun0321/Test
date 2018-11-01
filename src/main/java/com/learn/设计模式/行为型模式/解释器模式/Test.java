package com.learn.设计模式.行为型模式.解释器模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 3:43 PM
 */
public class Test {

    public static void main(String[] args){

        int result = new Minus().interpret(new Context(new Plus().interpret(new Context(9,2)),8));
        System.out.println(result);

    }

}
