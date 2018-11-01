package com.learn.设计模式.桥接模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 4:48 PM
 */
public abstract class Bridge  {

    private Sourceable sourceable;

    public void method(){
        sourceable.method();
    }

    public Sourceable getSourceable(){
        return  sourceable;
    }

    public void setSourceable(Sourceable sourceable){
        this.sourceable = sourceable;
    }


}
