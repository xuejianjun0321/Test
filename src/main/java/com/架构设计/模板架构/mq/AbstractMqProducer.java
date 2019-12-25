package com.架构设计.模板架构.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description
 * crm mq Producer 抽象类
 * @Author binwei
 * @Date 2019-12-11 9:00:30
 **/
@Slf4j
public abstract class AbstractMqProducer {

    /**
     * 获取自定的线程池
     */
    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     *  producerFactory
     */
    @Resource
    private ProducerFactory producerFactory;

    /**
     * producer 实例
     */
    private AtomicReference<Producer> producer = new AtomicReference<>();

    /**
     * 获取 groupName
     * @return
     */
    protected abstract String getGroupName();

    /**
     * 获取  TopicName
     * @return
     */
    protected  abstract  String getTopicName();

    /**
     * 获取  TopicName
     * @return
     */
    protected  abstract  String getTagName();

    /**
     * 获取group
     *
     * @return
     */
    private Group getGroup() {
        Group group = new Group( getGroupName());
        return group;
    }
    /**
     * 获取 topic
     * @return
     */

    private Topic getTopic() {
        Topic topic = new Topic(getTopicName());
        return topic;
    }

    private Producer getProducer() throws Exception {
        if (producer.get() == null) {
            Producer producer = producerFactory.createProducer(getTopic(), getGroup());
            producer.start();
            this.producer.compareAndSet(null, producer);
        }
        return producer.get();
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String message){
        threadPoolTaskExecutor.execute(()->{
            try {
                LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
                OfferResult result = getProducer().offer(new Msg(getTopicName(), getTagName(), message.getBytes()));
//                log.info("[发送MQ消息成功].groupName = {},topicName={},msgId:{},message:{}",
//                        getGroupName(),getTopicName(),result.getMsgId(),message );
            } catch (Exception e) {
//                log.error("[发送MQ消息失败].groupName = {},topicName={},message:{} e={}",
//                        getGroupName(),getTopicName(),message,e );

            }
        });
    }


    @PreDestroy
    public void destroy() {
        Producer producer = this.producer.get();
        if(producer!=null){
            producer.shutdown();
        }
    }
}

