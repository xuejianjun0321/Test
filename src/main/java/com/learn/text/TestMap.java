package com.learn.text;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/09/18 下午3:29
 */
public class TestMap  {

    public static void main(String[] args) {
        Map<Long,String> userMap = new HashMap<>();
        userMap.put(null,"32erq");
        userMap.put(233L,"esefdsf");
        for (Long user : userMap.keySet()){
            System.out.println(user);
            System.out.println("#######");
            System.out.println(userMap.get(user));
        }
    }
}
