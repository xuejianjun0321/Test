package com.架构设计.分支流程;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/09 20:40
 */
public interface InsComponent {

    /**
     * 决策处理
     *
     * @param insContext
     */
    public void execute(InsContext insContext);

}
