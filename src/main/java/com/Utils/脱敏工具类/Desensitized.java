package com.Utils.脱敏工具类;


import java.lang.annotation.*;

/**
 * TODO 脱敏注释
 *
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desensitized {

    /** 脱敏类型(规则) */
    SensitiveTypeEnum type();

    /** 判断注解是否生效的方法 */
    String isEffictiveMethod() default "";

}