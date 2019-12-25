package com.架构设计.模板架构.mq;


import lombok.Data;

import java.util.Arrays;

/**
 *
 * 消息对象.
 *
 * @author 莫那·鲁道
 * @date 2019-03-28-08:31
 */
@Data
public class Msg {

    /**
     * MQ Server 类型. rocketMQ;activeMQ;aliYunRocketMQ;
     */
    MQType mqType;
    /**
     * 消息基本单位.
     */
    String topic;

    /**
     * tag, 用于比 topic 更细粒度的区分.
     */
    String tags;

    /**
     * subExpression 过滤表达式, 使用 * 号,表示获取所有; 例如使用 TagA || TagC || TagD 表示只获取此 3 个 tag 的消息.
     */
    String subExpression = "*";

    /**
     * 消息内容.
     */
    private byte[] body;

    /**
     * 事务  ID.
     */
    private String transactionId;

    /**
     * 具体实现的源结果.
     */
    private Object origin;

    /**
     * 消息的唯一标识.
     */
    private String keys;


    /**
     * 唯一 ID, 但不可做幂等使用.
     */
    private String msgId;


    /**
     * 消息延迟级别:
     * 1:  1s
     * 2:  5s
     * 3:  10s
     * 4:  30s
     * 5:  1m
     * 6:  2m
     * 7:  3m
     * 8:  4m
     * 9:  5m
     * 10: 6m
     * 11: 7m
     * 12: 8m
     * 13: 9m
     * 14: 10m
     * 15: 20m
     * 16: 30m
     * 17: 1h
     * 18: 2h
     */
    private DelayMsgLevel delayMsgLevel;

    /**
     * 消息的重试次数.
     */
    private int reconsumeTimes;

    /**
     * for deserializer.
     */
    public Msg() {
    }

    public Msg(byte[] body) {
        this.body = body;
    }

    public Msg(String topic, byte[] body) {
        this.topic = topic;
        this.body = body;
    }

    public Msg(String topic, String tags, byte[] body) {
        this.topic = topic;
        this.tags = tags;
        this.body = body;
    }


    public Msg(String topic, byte[] body, MQType mqType) {
        this.topic = topic;
        this.body = body;
        this.mqType = mqType;
    }

    public Msg(String topic, String tags, byte[] body, MQType mqType) {
        this.topic = topic;
        this.tags = tags;
        this.body = body;
        this.mqType = mqType;
    }

    public Msg(String topic, String tags, byte[] body, Object origin) {
        this.topic = topic;
        this.tags = tags;
        this.body = body;
        this.origin = origin;
    }

    public Msg(String topic, String tags, byte[] body, String msgId, Object origin) {
        this.topic = topic;
        this.tags = tags;
        this.body = body;
        this.msgId = msgId;
        this.origin = origin;
    }

    public Msg(String topic, String tags, byte[] body, String msgId, Object origin, MQType mqType) {
        this.topic = topic;
        this.tags = tags;
        this.body = body;
        this.msgId = msgId;
        this.origin = origin;
        this.mqType = mqType;
    }

    @Override
    public Msg clone() throws CloneNotSupportedException {
        Msg msg = new Msg(this.getBody());
        msg.mqType = this.mqType;
        msg.topic = this.topic;
        msg.tags = this.tags;
        msg.subExpression = this.subExpression;
        msg.transactionId = this.transactionId;
        msg.origin = this.origin;
        msg.keys = this.keys;
        msg.msgId = this.msgId;
        msg.delayMsgLevel = this.delayMsgLevel;
        return msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "mqType=" + mqType +
                ", topic='" + topic + '\'' +
                ", tags='" + tags + '\'' +
                ", subExpression='" + subExpression + '\'' +
                ", body=" + Arrays.toString(body) +
                ", transactionId='" + transactionId + '\'' +
                ", origin=" + origin +
                ", keys='" + keys + '\'' +
                ", msgId='" + msgId + '\'' +
                ", delayMsgLevel=" + delayMsgLevel +
                '}';
    }
}
