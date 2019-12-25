package com.Utils;

import com.common.exception.BaseRuntimeException;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/12/25 16:47
 */
public class BeanConvertUtil {

    /**
     * 转化为普通对象
     */
    public static <T> T convert(Object source, Class<T> target) {
        try {
            T o = target.newInstance();
            BeanUtils.copyProperties(source, o);
            return o;
        } catch (Exception e) {
            throw new BaseRuntimeException("convertor exception", e);
        }
    }

    /**
     * 转化为列表对象
     */
    public static <T> List<T> convertList(List sourceList, Class<T> target) {
        try {
            List<T> list = new ArrayList<>();
            T o = null;
            for (int i = 0; i < sourceList.size(); i++) {
                o = target.newInstance();
                BeanUtils.copyProperties(sourceList.get(i), o);
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            throw new BaseRuntimeException("convertor list exception", e);
        }
    }

}
