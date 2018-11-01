package com.learn.设计模式.命令模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 10:17 AM
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver){
        this.receiver = receiver;
    }


    @Override
    public void exe() {
        receiver.action();
    }
}
