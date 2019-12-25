package com.架构设计.模板架构.mq;

import lombok.Data;
import lombok.ToString;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 配置类.
 *
 * @author 莫那·鲁道
 * @date 2019-03-28-08:54
 */
@Data
@ToString
public class MQConfig {

    /**
     * MQ 的类型, 例如 rocket, active 等.
     */
    @Deprecated
    String mqType = MQType.ROCKET.getName();

    /**
     * 具体实现给定的 消费者 实现类名.
     */
    String consumerFactoryClassName = null;

    /**
     * 具体实现给定的 生产者 实现类名.
     */
    String producerFactoryClassName = null;

    /**
     * 事务生产者. 类名
     */
    String transactionProducerFactoryClassName;

    /**
     * RocketMQ 的 NameServer 地址.
     */
    @Deprecated
    String nameSrv;

    /**
     * ACL 的 accessKey.
     */
    @Deprecated
    String ak;

    /**
     * ACL 的 secretKey.
     */
    @Deprecated
    String sk;

    /**
     * 扩展属性. 例如, 每个具体实现的 MQ 的网络连接配置.
     */
    Map<String, String> extConfig = new ConcurrentHashMap<>(2);

    public void setProperty(String key, String value) {
        extConfig.put(key, value);
    }

    public String getProperty(String key, String defaultValue) {
        String v = extConfig.get(key);
        if (v == null) {
            return defaultValue;
        }
        return v;
    }

}
