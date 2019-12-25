package com.架构设计.模板架构;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Description: 模板请求对象
 * <p></p>
 * @Author: shaoye
 * Date: 2019-11-18 21:18
 */
@Getter
@Setter
@Accessors(chain = true)
public class TemplateResponse<T extends Object> extends BaseServiceResponse {

    /**
     * 请求体
     */
    private T body;

    /**
     * 构建 TemplateResponse
     */
    public static <T> TemplateResponse<T> builder(T body) {
        return new TemplateResponse().setBody(body);
    }

}
