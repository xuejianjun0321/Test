package com.learn.设计模式.创建型模式.单例模式.hungry;

/**
 * Created by Tom.
 */

//饿汉式静态块单例
public class HungryStaticSingleton {
    private static final HungryStaticSingleton hungrySingleton;
    static {
        hungrySingleton = new HungryStaticSingleton();
    }
    private HungryStaticSingleton(){}
    public static HungryStaticSingleton getInstance(){
        return  hungrySingleton;
    }
}
