package com.架构设计.模板架构.mq;

import lombok.Data;
import lombok.ToString;

/**
 *
 * 接收消息并处理后,返回该对象.
 *
 * @author 莫那·鲁道
 * @date 2019-03-28-08:31
 */
@Data
@ToString
public class ReceiveResult {

    /**
     * 处理成功或失败.
     */
    boolean receiveSuccess;

    /**
     * 是否"稍后处理".
     */
    boolean receiveLater;

    public ReceiveResult(boolean receiveSuccess) {
        this.receiveSuccess = receiveSuccess;
    }

    public static ReceiveResult success() {
        return new ReceiveResult(true);
    }

    public static ReceiveResult fail() {
        return new ReceiveResult(false);
    }
}