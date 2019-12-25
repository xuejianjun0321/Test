package com.Utils;

import com.alibaba.csp.ahas.shaded.com.taobao.diamond.utils.StringUtils;
import com.common.exception.BaseIllegalArgumentException;
import org.apache.commons.collections.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/25 17:14
 */
public class ValidatorUtil {

    /**
     * 参数验证
     */
    public static <T> void validate(T t) {
        // 获得验证器
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        // 执行验证
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        // 如果有验证信息，则取出来包装成异常返回
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            throw new BaseIllegalArgumentException(convertErrorMsg(constraintViolations));
        }
    }

    /**
     * 转换异常信息
     */
    private static <T> String convertErrorMsg(Set<ConstraintViolation<T>> set) {
        StringBuilder sb = new StringBuilder();

        for (ConstraintViolation<T> cv : set) {
            if (StringUtils.isEmpty(sb.toString())) {
                sb.append(cv.getMessage()).append("[").append(cv.getPropertyPath().toString()).append("]");
            } else {
                sb.append(", ").append(cv.getMessage()).append("[").append(cv.getPropertyPath().toString()).append("]");
            }
        }

        return sb.toString();
    }


}
