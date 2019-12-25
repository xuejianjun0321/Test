package com.架构设计.模板架构.mq;

/**
 *
 * 生命周期接口.
 *
 * @author 莫那·鲁道
 * @date 2019-03-28-08:35
 */
public interface LifeCycle {

    /**
     * 启动.
     *
     * @throws Exception 启动时可能会失败, 用户需要处理.
     */
    void start() throws Exception;

    /**
     * 关闭.
     */
    void shutdown();

    /**
     * 是否已经启动.
     *
     * @return 已经启动, 返回 {@code true}, 反之, 返回 {@code false}
     */
    boolean isStared();

    /**
     * 是否已经关闭.
     * @return 已经关闭, 返回 {@code true}, 反之, 返回 {@code false}
     */
    boolean isShutDowned();

}
