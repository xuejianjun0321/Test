package com.中间件.hbase.utils;

import com.中间件.hbase.constant.CommonResultEnum;
import com.中间件.hbase.constant.ICodeEnum;
import com.中间件.hbase.exceptions.RestServiceException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/18 21:36
 */
public class EnumUtils {

    public static String EnumToString(Enum source) {
        if (source != null) {
            return source.toString();
        } else {
            return null;
        }
    }

    public static <T extends Enum<T>> T StringToEnum(String source, Class<T> enumClass) {
        try {
            return Enum.valueOf(enumClass, source);
        } catch (NullPointerException | IllegalArgumentException e) {
            return null;
        }
    }

    public static <T extends Enum<T>> T StringToEnum(String source, Class<T> enumClass, String errorMessage) {
        try {
            return Enum.valueOf(enumClass, source);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new RestServiceException(CommonResultEnum.PARAM_WRONG, errorMessage);
        }
    }

    public static <K extends Number, T extends Enum> String getFromMap(K key, Map<K, T> enumMap) {
        if (key != null) {
            Enum enumObject = enumMap.get(key);
            if (enumObject != null) {
                return enumObject.name();
            }
        }
        return null;
    }

    public static <T extends Enum<T> & ICodeEnum> Map<Byte, T> initEnumMap(Class<T> tClass) {

        Map<Byte, T> initMap = new HashMap<>();
        for (T tEnum : tClass.getEnumConstants()) {
            initMap.put(tEnum.getCode(), tEnum);
        }
        return initMap;
    }

}
