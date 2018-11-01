package com.learn.设计模式.访问者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 3:21 PM
 */
public class Test {

    public static void main(String[] args){
        Visitor visitor = new MyVisitor();
        Subject subject = new MySubject();
        subject.accept(visitor);
    }

}
