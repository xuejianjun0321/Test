package com.手撕算法.牛客网.字符串;

import java.util.Scanner;
/**
 * 描述
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 *
 * 输入描述：
 * 输入一行字符串，可以有空格
 *
 * 输出描述：
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 */
public class 统计字符 {

    /**
     * 思路：
     * 依次清除英文字母、空格、数字。
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.nextLine();
            String s1=str.replaceAll("[A-Z]+|[a-z]+", "");
            System.out.println(str.length()-s1.length());
            String s2=s1.replaceAll(" ", "");
            System.out.println(s1.length()-s2.length());
            String s3=s2.replaceAll("[0-9]+", "");
            System.out.println(s2.length()-s3.length()+"\n"+s3.length());
        }
    }
}
