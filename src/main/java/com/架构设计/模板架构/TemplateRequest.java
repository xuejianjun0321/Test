package com.架构设计.模板架构;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 模板请求对象
 * <p></p>
 * @Author: shaoye
 * Date: 2019-11-18 21:18
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class TemplateRequest<T extends Object> extends BasebServiceRequest {

    /**
     * 上下文对象
     */
    private final Map<String, Object> context = new HashMap<>();

    /**
     * 请求体（入参）
     */
    private T body;

    /**
     * 构建 TemplateRequest
     */
    public static <T> TemplateRequest<T> builder(T t) {
        return new TemplateRequest().setBody(t);
    }

    /**
     * 添加上下文
     */
    public  void addToContext(String key, Object obj) {
        this.getContext().put(key, obj);
    }

    /**
     * 获取上下文对象
     */
    public Object getFromContext(String key) {
        return this.getContext().get(key);
    }

}
