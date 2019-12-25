package com.Utils;

import com.common.exception.BaseRuntimeException;
import com.common.enums.BaseEnum;

/**
 * 枚举工具类
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/25 17:04
 */
public class EnumUtil {

    /**
     * 通过 value 获取枚举对象
     *
     * @param value  枚举值
     * @param tClass 枚举类
     * @param <T>
     * @return 枚举对象
     */
    public static <T extends BaseEnum> T getByValue(Integer value, Class<T> tClass) {
        for (T e : tClass.getEnumConstants()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }

        throw new BaseRuntimeException("convert value: " + value + " to enum: " + tClass.getSimpleName() + " error");
    }

    public static <T extends BaseEnum> String toString(T t) {
        return t.toString();
    }

}
