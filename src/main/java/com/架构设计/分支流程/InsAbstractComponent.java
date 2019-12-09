package com.架构设计.分支流程;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/09 20:45
 */
public abstract class InsAbstractComponent implements InsComponent {

    private Logger logger = LogConstants.CORE_SERVICE_LOGGER;

    /**
     * 决策处理前
     *
     * @param insContext
     */
    public void before(InsContext insContext) {
        logger.info("决策处理前 , insContext:{}.", JSON.toJSONString(insContext));
    }

    @Override
    public void execute(InsContext insContext) {
        /** 前置处理 */
        before(insContext);

        /** 处理集合 */
        handle(insContext);

        /** 后置处理 */
        after(insContext);
    }

    public abstract void handle(InsContext insContext);

    /**
     * 决策处理后
     *
     * @param insContext
     */
    public void after(InsContext insContext) {
        logger.info("决策处理后, insContext:{}.",JSON.toJSONString(insContext));
    }

}
