package com.架构设计.模板架构.mq;

import com.架构设计.模板架构.TemplateRequest;
import com.架构设计.模板架构.TemplateResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName mq 消息监听器
 * @Description //TODO
 * @Author qiming
 * @Date 2019-11-02 23:11:58
 **/
@Slf4j
public abstract class AbstractMqListener<R> implements Listener {

    @Override
    public ReceiveResult receive(List<Msg> list) {
        try {
            List<R> result = list.stream()
                    .map(msg -> excute(msg))
                    .collect(Collectors.toList());
            ReceiveResult.success();
        } catch (Exception e) {
            log.error("excute error ", e);
            return ReceiveResult.fail();

        }
        return ReceiveResult.success();
    }

    protected R excute(Msg msg) {
        TemplateRequest<Msg> request = TemplateRequest.builder(msg);
        TemplateResponse<R> response = getTemplate().execute(request);
        return response.getBody();
    }

    /**
     *获取模板
     * @return AbstractMqTemplate
     */
    public abstract AbstractMqTemplate getTemplate();
}

