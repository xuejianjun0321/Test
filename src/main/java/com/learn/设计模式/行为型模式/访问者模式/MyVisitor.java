package com.learn.设计模式.行为型模式.访问者模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/01 3:19 PM
 */
public class MyVisitor implements Visitor {
    @Override
    public void visit(Subject subject) {
        System.out.println("visit the subject:" + subject.getSubject());
    }
}
