package com.common.enums;

/**
 * Description: BaseEnum
 * <p></p> 抽象 枚举 接口
 * @Author: shaoye
 * Date: 2019-11-15 14:17
 */
public interface BaseEnum<T> {

    /**
     * 获取 value 值
     *
     * @return
     */
    abstract T getValue();
}
