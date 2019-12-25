package com.架构设计.模板架构.mq;

/**
 *
 * @author 莫那·鲁道
 * @date 2019-03-28-10:15
 */
public class MqException extends RuntimeException {

    public MqException() {
    }

    public MqException(String message) {
        super(message);
    }

    public MqException(String message, Throwable cause) {
        super(message, cause);
    }

    public MqException(Throwable cause) {
        super(cause);
    }

    public MqException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
