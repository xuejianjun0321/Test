package com.手撕算法.数组相关;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 15:39
 */
public class Test {

    public static void main(String [] args){

        int [] nums = {1,4,2,2,7,2,2};

        查找多数元素 sarch = new 查找多数元素();
        System.out.println(sarch.majorityElement(nums));
        System.out.println("----------------");
        System.out.println(sarch.majorityElement2(nums));

        int [] nums2 = {4,7,82,54};
        把数组排成最小的数 min = new 把数组排成最小的数();
        System.out.println(min.PrintMinNumber(nums2));

    }

}
