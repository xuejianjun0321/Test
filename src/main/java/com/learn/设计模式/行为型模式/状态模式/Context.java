package com.learn.设计模式.行为型模式.状态模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 3:00 PM
 */
public class Context {

    private State state;

    public Context(State state){
        this.state = state;
    }

    public void metchod(){
        if (state.getValue().equals("state1")){
            state.method1();
        }else if (state.getValue().equals("state2")){
            state.method2();
        }
    }

}
