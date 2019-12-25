package com.架构设计.模板架构.mq;

import lombok.Data;
import lombok.ToString;

/**
 *
 * 插入队列后的结果.
 *
 * @author 莫那·鲁道
 * @date 2019-03-28-08:31
 */
@ToString
@Data
public class OfferResult {

    /**
     * MQ Server 类型. rocketMQ;activeMQ;aliYunRocketMQ;
     */
    MQType mqType;

    /**
     * 是否成功.
     */
    boolean success;

    /**
     * 消息唯一 ID, 务必保存, 方便回溯.
     */
    String msgId;

    /**
     * 原始返回值对象.
     */
    Object origin;


    public OfferResult(boolean success, String msgId) {
        this.success = success;
        this.msgId = msgId;
    }


    public OfferResult(boolean success, MQType mqType) {
        this.success = success;
        this.mqType = mqType;
    }

    public OfferResult(boolean success, String msgId, Object origin, MQType mqType) {
        this.success = success;
        this.msgId = msgId;
        this.origin = origin;
        this.mqType = mqType;
    }
}
