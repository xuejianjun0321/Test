package com.手撕算法.牛客网;

import java.util.Scanner;
/**
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 * 数据范围： 0 \le n \le 2^{30}-1 \0≤n≤2
 * 30
 *  −1
 */
public class 数字颠倒 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuffer strb = new StringBuffer(str);
        strb.reverse();
        System.out.println(strb.toString());
    }

}
