package com.架构设计.模板架构;



import org.apache.commons.lang3.ObjectUtils;

import java.util.Map;

/**
 * @Description 合同相关通用模板基类
 * @Author qiming
 * @Date 2019-11-21 20:11:53
 **/
public abstract class AbstractBaseContractTemplate<PARAMS, INPUT, OUTPUT, RESULT> extends
        AbstractContractTemplate<TemplateRequest<PARAMS>, INPUT, OUTPUT, TemplateResponse<RESULT>> {

    @Override
    protected void init(TemplateRequest<PARAMS> request) {
    }

    @Override
    protected void preCheck(TemplateRequest<PARAMS> request) {
        if (ObjectUtils.isEmpty(request.getBody())) {
            throw new RuntimeException("TemplateRequest's body is null");
        }

        for (Map.Entry<String, Object> entry : request.getContext().entrySet()) {
            if (entry.getValue() == null) {
                throw new RuntimeException(
                        ContractResultEnum.CONTEXT_EXCEPTION.getMsg() + ": " + entry.getKey() + " is null");
            }
        }
    }

    @Override
    protected void check(INPUT input) {
    }

    @Override
    protected void postProcess(TemplateRequest<PARAMS> request, OUTPUT output) {
    }

    @Override
    protected void addExceptionEvent(INPUT inputDTO, Exception e) {
    }

}

