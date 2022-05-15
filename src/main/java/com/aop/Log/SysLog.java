package com.aop.Log;

import java.lang.annotation.*;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/26 20:42
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SysLog {

    String requestUrl();

    String message() default "参数有误";
}