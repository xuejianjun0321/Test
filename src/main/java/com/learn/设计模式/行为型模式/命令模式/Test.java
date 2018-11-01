package com.learn.设计模式.行为型模式.命令模式;

/**
 * 命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 10:21 AM
 */
public class Test {

    public static void main(String[] args){
        Receiver receiver = new Receiver();
        Command command = new MyCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();

    }

}
