package com.手撕算法.牛客网;

import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

/**
 * 描述
 * 题目标题：
 *
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 * 输出时相邻两数之间没有空格。
 */
public class 整型数组合并 {

    /**
     审题：数组升序合并、过滤重复元素 (很明显这是考察 TreeSet 的用法)
     TreeSet 的性质：有序、不重复
     **/

    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            Set<Long> set = new TreeSet<>();
            //接收第一个整形数组大小
            int size1 = sc.nextInt();
            for (int i = 0; i < size1; i++) {
                set.add(sc.nextLong()); //将该组的整数按数组大小循环添加进 set
            }
            //接收第一个整形数组大小
            int size2 = sc.nextInt();
            for (int i = 0; i < size2; i++) {
                set.add(sc.nextLong());
            }
            //遍历输出
            for (long n : set) {
                System.out.print(n);
            }
          /*
          注意：测试案例会以 两个整形数组 为一组测试用例， 并可能输入多组
          要记得组与组的结果之间换行
          */
            System.out.println();
        }

    }
}