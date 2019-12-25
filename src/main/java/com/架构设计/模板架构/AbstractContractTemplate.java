package com.架构设计.模板架构;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractContractTemplate<REQUEST extends TemplateRequest, INPUT, OUTPUT, RESPONSE extends TemplateResponse> {

    /**
     * 模板入口方法
     *
     * @param request
     * @return
     */
    public RESPONSE execute(REQUEST request) {
        // 初始化
        init(request);
        // 准入check
        preCheck(request);
        // 构建内部输入对象
        INPUT inputDTO = convert(request);
        // 内部输入对象检查
        check(inputDTO);
        // 核心逻辑处理
        OUTPUT outputDTO = null;
        try {
            outputDTO = process(inputDTO);
        } catch (Exception e) {
            log.error("AbstractContractTemplate process is error", e);
            addExceptionEvent(inputDTO, e);
            throw new RuntimeException(e.getMessage());
        }
        // 内部输出对象
        postProcess(request, outputDTO);
        // 转换为 返回对象
        return render(outputDTO);
    }

    /**
     * init
     *
     * @param request 初始化 REQUEST
     */
    protected abstract void init(REQUEST request);

    /**
     * request 预校验
     *
     * @param request
     */
    protected abstract void preCheck(REQUEST request);

    /**
     * 数据转化
     *
     * @param request
     * @return INPUT
     */
    protected abstract INPUT convert(REQUEST request);

    /**
     * 常规校验，比如说鉴权，业务校验
     *
     * @param input
     */
    protected abstract void check(INPUT input);

    /**
     * 业务处理
     *
     * @param input
     * @return OUTPUT
     */
    protected abstract OUTPUT process(INPUT input);

    /**
     * 业务后置处理 (消息，通知 发送（mq，钉钉，短信，邮件等）)
     *
     * @param request
     * @param output
     */
    protected abstract void postProcess(REQUEST request, OUTPUT output);

    /**
     * 数据渲染
     *
     * @param output
     * @return RESPONSE
     */
    protected abstract RESPONSE render(OUTPUT output);

    /**
     * 添加异常事件
     *
     * @param inputDTO
     * @param e
     */
    protected abstract void addExceptionEvent(INPUT inputDTO, Exception e);
}