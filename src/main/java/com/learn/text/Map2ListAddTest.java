package com.learn.text;

import java.util.*;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/11/23 5:05 PM
 */
public class Map2ListAddTest {

    public static void main(String[] args){

        Map<String,List<String>> testMap = new HashMap<>();
        String id = "test";
        List<String> testList = new ArrayList<>();
        testList.add("A");
        testMap.put(id,testList);


        testList.add("B");
        testList.add("C");

        for (String srt : testMap.get(id)){
            System.out.println(srt);
        }


    }

}
