package com.架构设计.模板架构.mq;

import java.util.List;

/**
 * 消费者监听器接口.
 *
 * @author 莫那·鲁道
 * @date 2019-03-28-09:20
 */
public interface Listener {

    /**
     * 接收消息,并消费. 使用时注意做好幂等.
     *
     * @param msgs 消息集合
     * @return 消费成功或重试.
     */
    ReceiveResult receive(List<Msg> msgs);
}
