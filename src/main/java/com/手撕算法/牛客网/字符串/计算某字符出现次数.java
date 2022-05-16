package com.手撕算法.牛客网.字符串;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000
 */
public class 计算某字符出现次数 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String input1= s.nextLine();
        String input2 = s.nextLine();
        String split3 = input1.toUpperCase().replaceAll(input2.toUpperCase(),"");
        System.out.println(input1.length() - split3.length());
    }

}
