package com.Utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/12/03 5:05 PM
 */
public class MapUtils {
    public static final char UNDERLINE = '_';

    /**
     * 下划线方式转驼峰
     * @param <T>
     */
    public static <T> Map<String, T> underlineToCamel(Map<String, T> param) {
        if (param == null) {
            return null;
        }
        Map<String, T> retMap = new HashMap<String, T>();
        Set<String> list = param.keySet();
        for (String string : list) {
            String str = string.toLowerCase();
            int len = str.length();
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                if (c == UNDERLINE) {
                    if (++i < len) {
                        sb.append(Character.toUpperCase(str.charAt(i)));
                    }
                } else {
                    sb.append(c);
                }
            }
            String key = sb.toString();
            retMap.put(key, param.get(string));
        }

        return retMap;
    }

    /**
     * map转javabean
     * @param <T>
     */
    public static <T> T convertMap(Class type, Map map)
            throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
        T obj = (T) type.newInstance(); // 创建 JavaBean 对象

        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors = beanInfo
                .getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();

            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                Object value = map.get(propertyName);

                Object[] args = new Object[1];
                args[0] = value;

                descriptor.getWriteMethod().invoke(obj, args);
            }
        }
        return obj;
    }

    public static Map<String, String> sumMapForString(Map<String, String> a,
                                                      Map<String, String> b) {
        /**
         * @Return java.util.Map<java.lang.String,java.lang.String>
         * @Description 将两个Map<String, String>拼接成一个
         * @param a
         * @param b
         */
        Map<String, String> res = new HashMap<String, String>();
        for (Map.Entry<String, String> aMap : a.entrySet()) {
            res.put(aMap.getKey(), aMap.getValue());
        }
        for (Map.Entry<String, String> bMap : b.entrySet()) {
            if (res.containsKey(bMap.getKey())) {
                String key = bMap.getKey();
                int aValue = Integer.valueOf(res.get(key));
                int bValue = Integer.valueOf(bMap.getValue());
                int temp = aValue + bValue;
                res.put(key, temp + "");
            } else {
                res.put(bMap.getKey(), bMap.getValue());
            }
        }
        return b;
    }

    public static Map<String, Integer> sumMapForInteger(Map<String, Integer> a,
                                                        Map<String, Integer> b) {
        /**
         * @Return java.util.Map<java.lang.String,java.lang.Integer>
         * @Description 将两个Map<String, Integer>拼接成一个
         * @param a
         * @param b
         */
        Map<String, Integer> res = new HashMap<String, Integer>();
        for (Map.Entry<String, Integer> aMap : a.entrySet()) {
            res.put(aMap.getKey(), aMap.getValue());
        }
        for (Map.Entry<String, Integer> bMap : b.entrySet()) {
            if (res.containsKey(bMap.getKey())) {
                String key = bMap.getKey();
                int aValue = res.get(key);
                int bValue = bMap.getValue();
                int temp = aValue + bValue;
                res.put(key, temp);
            } else {
                res.put(bMap.getKey(), bMap.getValue());
            }
        }
        return res;
    }

    /**
     * Map<String, Object>转换成Map<String, String>
     *
     * @param map
     * @return
     */
    public static Map<String, String> objectToString(Map<String, Object> map) {
        Map<String, String> res = new HashMap<String, String>();
        for (Map.Entry<String, Object> iterable : map.entrySet()) {
            if(!(iterable.getValue() ==null)){
                res.put(iterable.getKey(), iterable.getValue().toString());
            }else {
                res.put(iterable.getKey(), "");
            }

        }
        return res;
    }

    /**
     * 将Map中的value取出存入List
     *
     * @param map
     * @return
     */
    public static List<String> mapToList(Map<String, String> map) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> string : map.entrySet()) {
            list.add(string.getValue());
        }
        return list;
    }



    /**
     * MODULE   : sortMapByValue
     * ABSTRACT : 将map的值从大到小排序
     * @author  : BJ
     * @param   ：HashMap<String, Integer>
     * @return  ：TreeMap<String, Integer>
     * @note    : 将map的值从大到小排序
     */
    public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
        Comparator<String> comparator = new ValueComparator(map);
        //TreeMap is a map sorted by its keys.
        //The comparator is used to sort the TreeMap by keys.
        TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
        result.putAll(map);
        return result;
    }



}


class ValueComparator implements Comparator<String>{

    HashMap<String, Integer> map = new HashMap<String, Integer>();

    public ValueComparator(HashMap<String, Integer> map){
        this.map.putAll(map);
    }

    @Override
    public int compare(String s1, String s2) {
        if(map.get(s1) >= map.get(s2)){
            return -1;
        }else{
            return 1;
        }
    }

}
