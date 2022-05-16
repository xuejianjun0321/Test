package com.手撕算法.牛客网;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * 描述
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
 * 现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
 * 注意：字典中可能有重复单词。
 *
 * 数据范围：1 \le n \le 1000 \1≤n≤1000 ，输入的字符串长度满足 1 \le len(str) \le 10 \1≤len(str)≤10  ， 1 \le k < n \1≤k<n
 */
public class 查找兄弟单词 {

    /**
     * 1、对n个单词升序排序
     * 2、第n个单词和 x 相等 和 长度不一致的跳过
     * 3、对第n个单词 和 x 的每个字符升序排序，并比较是否相等，如果相等则为兄弟单词。
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            List<String> datas = new ArrayList();
            for(int i = 0 ; i < num ; i++){
                datas.add(in.next());
            }
            String x = in.next();
            char[] xs = x.toCharArray();//取反
            int index = in.nextInt();
            Collections.sort(datas);
            int count = 0;
            String k = "";
            for(String str : datas){
                if(x.equals(str) || x.length() != str.length()){
                    continue; //字符串一样 和 长度不一样的跳过
                }
                char[] strs = str.toCharArray();
                Arrays.sort(xs);
                Arrays.sort(strs);
                if(!Arrays.equals(strs,xs)){
                    continue;//升序排序不相等，跳过
                }
                count += 1; // 满足条件的累加
                if (count == index) {
                    k = str;//第K个兄弟单词
                }
            }
            System.out.println(count);
            System.out.println(k);
        }
    }
}
