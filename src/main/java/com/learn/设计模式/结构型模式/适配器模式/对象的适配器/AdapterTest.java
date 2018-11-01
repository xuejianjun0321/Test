package com.learn.设计模式.结构型模式.适配器模式.对象的适配器;

import com.learn.设计模式.结构型模式.适配器模式.类的适配器.Source;
import com.learn.设计模式.结构型模式.适配器模式.类的适配器.Targetable;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 11:44 AM
 */
public class AdapterTest {

    public static void main(String[] args){
        Source source = new Source();
        Targetable targetable = new Wrapper(source);
        targetable.method1();
        targetable.method2();
    }

}
