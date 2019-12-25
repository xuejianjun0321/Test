package com.架构设计.模板架构.mq;

import com.架构设计.模板架构.AbstractBaseContractTemplate;
import com.架构设计.模板架构.TemplateRequest;
import com.架构设计.模板架构.TemplateResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * mq 消息处理工厂 接口类
 * @author qiming
 */
@Slf4j
public abstract class AbstractMqProcessFactory<R, request extends TemplateRequest,template extends AbstractBaseContractTemplate>   {

    public R execute(request request) {
        try {
            TemplateResponse response = getProcessStrategy(request).execute(request);
            return (R) response.getBody();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            log.error("工作流消息处理策略执行异常", e);
            throw new RuntimeException("工作流消息处理策略执行异常");
        }
    }

    /**
     * 获取处理策略
     * @param request
     * @return
     */
    protected abstract template getProcessStrategy(request request);

}
