package com.learn.设计模式.适配器模式.接口的适配器;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 11:53 AM
 */
public class WrapperTest {
    public static void main(String[] args){
        Sourceable sourceable1 = new SourceSub1();
        Sourceable sourceable2 = new SourceSub2();
        sourceable1.method1();
        sourceable1.method2();
        sourceable2.method1();
        sourceable2.method2();
    }

}
