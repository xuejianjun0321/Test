package com.learn.反射.动态代理;

import java.util.Date;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/15 4:13 PM
 */
public class Logger {

    /**
     * 根据等级记录日志
     * @param level
     * @param context
     */
    public static void logging(Level level,String context){
        if (level.equals(Level.INFO)){
            System.out.println(new Date().toString() + " "+ context);
        }

        if (level.equals(Level.DEBUGE)){
            System.out.println(new Date().toString() +" " + context);
        }

    }

}
