package com.架构设计.模板架构.mq;
/**
 *
 * consumer 和 producer 都需要设置配置和获取配置.
 *
 * @author 莫那·鲁道
 * @date 2019-04-30-21:28
 */
public interface Config {

    void setConfig(MQConfig mqConfig);

    MQConfig getConfig();

}
