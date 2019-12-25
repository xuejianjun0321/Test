package com.架构设计.模板架构.mq;

/**
 *
 * @author 莫那·鲁道
 * @date 2019-04-30-21:24
 */
public enum MQType {

    ACTIVE("activeMQ"),
    ACTIVE_2("activeMQ_2"),
    ROCKET("rocketMQ"),
    ALI_YUN_ROCKET("aliYunRocketMQ");

    String name;

    MQType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
