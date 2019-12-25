package com.架构设计.模板架构.mq;

/**
 * 工厂创建实例时的钩子, 可以在创建钱做些动作, 也可以在创建成功后做些动作.
 *
 * @author 莫那·鲁道
 * @date 2019-05-02-19:32
 */
public interface CreateInstanceHook<Instance> {

    /**
     * 创建实例之前调用.
     *
     * @param args 创建实例需要的参数.
     * @return 可能修改后的参数.
     */
    Object createBefore(Object args);


    /**
     * 创建实例成功之后调用此方法.
     * @param o  实例.
     * @return 可能是修改后的实例. 具体逻辑由钩子自己处理.
     */
    Instance createAfter(Instance o);

}
