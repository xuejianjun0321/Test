package com.learn.设计模式.行为型模式.状态模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 3:02 PM
 */
public class Test {

    public static void main(String[] args){

        State state = new State();
        Context context =new Context(state);

        //设置第一种状态
        state.setValue("state1");
        context.metchod();

        //设置第二种状态
        state.setValue("state2");
        context.metchod();
    }

}
