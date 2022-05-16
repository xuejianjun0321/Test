package com.手撕算法.牛客网.字符串;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 20 \1≤n≤20  ，保证输入的字符串中仅出现小写字母
 */
public class 删除字符串中出现次数最少的字符 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Map<Character,Integer> map = new HashMap<>();
        while(in.hasNextLine()){
            int min = Integer.MAX_VALUE;
            String str = in.nextLine();
            int len = str.length();
            for(int i = 0; i < len; i++){
                char ch = str.charAt(i);
                if(!map.containsKey(ch)){
                    map.put(ch,1);
                    min = Math.min(min,1);
                }else{
                    int num = map.get(ch) + 1;
                    map.put(ch,num);
                    if(!map.containsValue(min)){//最小值增大的情况
                        min = num;
                    }
                }
            }
            for(int i = 0; i < len; i++){
                if(min != map.get(str.charAt(i))){
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
            map.clear();
        }
    }
}

