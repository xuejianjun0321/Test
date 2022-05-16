package com.手撕算法.牛客网.字符串;

import java.util.Scanner;
/**
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 */
public class 字符串反转 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuffer strb = new StringBuffer(str);
        strb.reverse();
        System.out.println(strb.toString());
    }

}
