package com.架构设计.模板架构.mq;

import java.util.Properties;

/**
 *
 * 生产者接口.
 *
 * @author 莫那·鲁道
 * @date 2019-03-28-07:55
 */
public interface Producer extends LifeCycle {

    /**
     * 添加消息到队列中.
     *
     * @param msg 消息.
     * @return msgId, 是否成功.
     * @throws MqException
     */
    OfferResult offer(Msg msg) throws MqException;

    /**
     * 单向发送.
     * 此方式能够提供发送吞吐量, 当业务对"消息丢失"不敏感时, 可使用此方式提高吞吐量.
     *
     * @param msg 消息体.
     * @throws MqException 发送异常.
     */
    void offerOneway(Msg msg) throws MqException;

    /**
     * 设置扩展属性.
     *
     * @param properties {@link Properties}
     */
    void setProperties(Properties properties);

    Topic getTopic();

    Group getGroup();

    Properties getProperties();

    /**
     * 默认 2000 毫秒.
     *
     * @param timeout 发送时,网络 timeout, 单位毫秒.
     */
    void setSendMsgTimeout(int timeout);

    /**
     * 是否开启本地磁盘 HA 功能. 如果开启,当发送网络闪断时,会将消息保存到本地. 待网络好转时, 然后使用异步定时任务发送.
     *
     * @param ha true 开启 ha, 默认 false 不开启.
     */
    void setHa(boolean ha);

    /**
     * 添加钩子: 在发送消息前后, 可使用此钩子进行拦截.
     * {@link OfferHook}
     */
    void addOfferHook(OfferHook hook);
}
