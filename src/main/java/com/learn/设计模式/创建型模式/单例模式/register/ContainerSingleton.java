package com.learn.设计模式.创建型模式.单例模式.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Tom.
 */

//Spring中的做法，就是用这种注册式单例
public class ContainerSingleton {
    private ContainerSingleton(){}
    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();
    public static Object getInstance(String className){
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }
}
