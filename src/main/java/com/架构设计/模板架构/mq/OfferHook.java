package com.架构设计.模板架构.mq;

/**
 * 调用 {@link Producer#offer(Msg)} 前后的钩子.
 *
 * 如果需要, 可以重写 compareTo 方法, 以实现钩子的执行排序.
 *
 * @author 莫那·鲁道
 * @date 2019-07-26-16:32
 */
public interface OfferHook extends Comparable{

    void beforeOffer(Msg msg);

    void afterOffer(Msg msg, OfferResult result);

    @Override
    default int compareTo(Object o) {
        return 0;
    }

}
