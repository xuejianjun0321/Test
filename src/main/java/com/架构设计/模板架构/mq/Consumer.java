package com.架构设计.模板架构.mq;

import java.util.Properties;

/**
 * 消费者接口定义.
 *
 * @author 莫那·鲁道
 * @date 2019-03-28-08:32
 */
public interface Consumer extends LifeCycle {

    /**
     * 注册消息监听器.
     *
     * @param listener 消息监听器.
     */
    void registerListener(Listener listener);


    /**
     * 订阅.
     *
     * @param topic 话题.
     */
    void subscribe(Topic topic);


    /**
     * 设置扩展属性.
     *
     * @param properties {@link Properties}
     */
    void setProperties(Properties properties);


    Topic getTopic();

    Group getGroup();

    Listener getListener();

    Properties getProperties();

}
