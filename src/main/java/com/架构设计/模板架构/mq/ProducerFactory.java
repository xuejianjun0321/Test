package com.架构设计.模板架构.mq;

/**
 *
 * 生产者工厂. 同一个工厂永远使用同一份配置.
 *
 * @author 莫那·鲁道
 * @date 2019-03-28-07:55
 */
public interface ProducerFactory extends Config {


    /**
     * 创建生产者, 具体实现见配置.
     *
     * @param topic topic. (当执行 offer 方法不指定 topic, 客户端就会使用这个 topic)
     * @param group 组名.
     * @return 具体实现.
     * @throws MqException 可能出现的网络异常.
     */
    Producer createProducer(Topic topic, Group group) throws MqException;

    /**
     * 创建生产者, 具体实现见配置.
     *
     * @param group 组名.
     * @return 具体实现.
     * @throws MqException 可能出现的网络异常.
     */
    Producer createProducer(Group group) throws MqException;

    /**
     * 添加创建对象时的 hook.
     * @param hook 钩子.
     */
    @UnstableApi
    void addCreateInstanceHook(CreateInstanceHook<Producer> hook);
}
