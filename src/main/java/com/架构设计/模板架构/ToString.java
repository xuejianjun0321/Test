package com.架构设计.模板架构;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * ToString基类
 * <pre>
 *  如果作为入参对象继承该类时，请重写toString方法，打印摘要日志会调用
 * </pre>
 *
 * @author LIU Kunpeng  WeChat:13758206010
 * @version $Id: ToString.java, v 0.1 2017年10月14日 上午10:13:44 LIU Kunpeng Exp $
 */
public class ToString implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -7277110490057966382L;

    /**
     * 重写toString方法
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }
}
