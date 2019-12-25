package com.架构设计.模板架构.mq;

import com.架构设计.模板架构.AbstractBaseContractTemplate;
import com.架构设计.模板架构.TemplateRequest;
import com.架构设计.模板架构.TemplateResponse;

/**
 * @ClassName MqTemplate
 * @Description TODO
 * @Author qiming
 * @Date 2019-11-21 18:11:34
 **/
public abstract class AbstractMqTemplate<input, output> extends AbstractBaseContractTemplate<Msg, input, output, output> {
    @Override
    protected void init(TemplateRequest<Msg> request) { }

    @Override
    protected void preCheck(TemplateRequest<Msg> request) { }


    @Override
    protected void check(input request) { }

    @Override
    protected TemplateResponse<output> render(output output) {
        TemplateResponse<output> response = TemplateResponse.builder(output);
        return response;
    }
}

