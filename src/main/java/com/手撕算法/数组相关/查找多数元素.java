package com.手撕算法.数组相关;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 找出一个数组中占50%以上的元素，即寻找多数元素，并且多数元素是一定存在的假设。
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 15:34
 */
public class 查找多数元素 {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else {
                int values = map.get(nums[i]);
                map.put(nums[i], ++values);
            }
        }
        int n = nums.length/2;
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while(iterator.hasNext()){
            int key = iterator.next();
            int value = map.get(key);
            if (value>n) {
                return key;
            }
        }
        return 0;
    }

    /** 最优 */
    public int majorityElement2(int[] nums) {
        int elem = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++)  {
            if(count == 0)  {
                elem = nums[i];
                count = 1;
            }else{
                if(elem == nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return elem;
    }
}
