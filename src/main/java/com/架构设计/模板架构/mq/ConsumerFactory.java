package com.架构设计.模板架构.mq;

/**
 *
 * 消费者工厂. 同一个工厂永远使用同一份配置.
 *
 * @author 莫那·鲁道
 * @date 2019-03-28-08:36
 */
public interface ConsumerFactory extends Config {


    /**
     * 创建消费者对象.
     *
     * @param group 组名.
     * @return 具体实现.
     */
    Consumer createConsumer(Group group);

    /**
     * 添加创建对象时的 hook.
     * @param hook 钩子.
     */
    void addCreateInstanceHook(CreateInstanceHook<Consumer> hook);


}
