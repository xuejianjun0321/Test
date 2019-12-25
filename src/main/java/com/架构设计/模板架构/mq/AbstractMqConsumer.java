package com.架构设计.模板架构.mq;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description crm mq Consumer 抽象类
 * @Author qiming
 * @Date 2019-12-10 14:12:30
 **/

public abstract class AbstractMqConsumer {

    /**
     * ConsumerFactory
     */
    @Resource
    private ConsumerFactory consumerFactory;
    /**
     * consumer 实例
     */
    private AtomicReference<Consumer> consumer = new AtomicReference<>();

    /**
     * 获取 groupname
     *
     * @return
     */
    protected abstract String getGroupName();

    /**
     * 获取
     *
     * @return
     */
    protected abstract String getTopicName();

    /**
     * 获取group
     *
     * @return
     */
    private Group getGroup() {
        return new Group(getGroupName());
    }

    /**
     * 获取 topic
     *
     * @return
     */

    private Topic getTopic() {
        return new Topic(getTopicName());
    }

    /**
     * 构建监听器
     *
     * @return
     */
    protected abstract Listener getListener();

    /**
     * 启动消息监听
     *
     * @throws Exception
     */
    @PostConstruct
    public void receiveMsg() throws Exception {
        if (consumer.get() == null) {
            Consumer consumer = consumerFactory.createConsumer(getGroup());
            consumer.subscribe(getTopic());
            consumer.registerListener(getListener());
            consumer.start();
            this.consumer.compareAndSet(null, consumer);
        }
    }

    @PreDestroy
    public void destroy() {
        Consumer c = consumer.get();
        if (c != null) {
            c.shutdown();
            this.consumer.compareAndSet(c, null);
        }
    }


}
