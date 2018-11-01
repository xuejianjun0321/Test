package com.learn.设计模式.单例模式;

/**
 * 单例对象，是一种常用的设计模式
 * 在Java应用中，单例对象能保证在一个jvm中，该对象只有一个实例存在
 * 这样的模式有几个好处：
 * 1，默写类创建比较繁琐，对于一些大型的对象，这是一笔很大的系统开销
 * 2.省去了new操作符，降低了系统内存的试用频率，减轻GC压力
 * 3，有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱掉了
 * 所以只有试用单列模式，才能保证核心交易服务器独立控制整个流程。
 *
 *
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/30 2:24 PM
 */
public class Singleton {

    /** 持有私有静态实例，防止被引用，此处赋值为null，目前是实现延迟加载 */
    private  static Singleton instance = null;

    /** 私有构造方法，防止被实例化 */
    private Singleton (){}

    /** 静态工程方法，创建实例 */
    public static Singleton getInstance(){
        if (instance ==null){
            instance = new Singleton();
        }
        return instance;
    }

    /** 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResoive(){
        return instance;
    }

    /** ----------------------------------------------------------------------------------------------------------- */

    /** 线程安全单例 */
    public static synchronized Singleton getSynInstance(){
        if (instance ==null){
            instance = new Singleton();
        }
        return instance;
    }

    /***
     * synchronized关键字锁住的是这个对象，
     * 这样的用法，在性能上会有所下降，
     * 因为每次调用getInstance()，都要对对象上锁，
     * 事实上，只有在第一次创建对象的时候需要加锁，之后就不需要了，
     * 所以，这个地方需要改进。我们改成下面这个：
     */

    public static Singleton getBestInstance(){
        if (instance == null){
            synchronized (instance){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /** ----------------------------------------------------------------------------------------------------------- */

    /**
     *
     *实际情况是，单例模式使用内部类来维护单例的实现，
     * JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。
     * 这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，
     * 并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题。
     * 同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。这样我们暂时总结一个完美的单例模式：
     *
     * */

    /**
     * 此处试用一个内部类来维护单例
     */
    private static class SingletonFatory{
         private static Singleton instance = new Singleton();
    }

    /**
     * 获取单例
     */

    public static Singleton getInstanceFat(){
        return SingletonFatory.instance;
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolveF(){
        return getInstanceFat();
    }




}
