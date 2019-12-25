package com.Utils.省市区工具类;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lc
 * @Date: 2018/11/29 11:12
 */
public class test {
    @Test
    public void test1(){
        LocalUtil lu =  LocalUtil.getInstance();
        List<String> list = 	lu.getCities("中国", "北京");
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
    @Test
    public void test2(){
        LocalUtil lu =  LocalUtil.getInstance();
        List<String> list = 	lu.getProvinces("中国");
        int j=0;
        for(int i=0; i<list.size(); i++){
            j++;
            System.out.print(list.get(i) + " "+"\n");
        }
        System.out.println(j);
    }
    @Test
    public  void test3(){
        LocalUtil lu = LocalUtil.getInstance();
        List<String> str = new ArrayList<>();
        List<String> list = lu.getcounty("中国", "浙江", "杭州");
        for (int i = 0; i < list.size(); i++) {
            str.add(list.get(i) + " ");
        }
        System.out.println(str);
    }
}
