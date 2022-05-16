package com.手撕算法.牛客网;
import java.util.Scanner;
/**
 * 描述
 * 将一个字符中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
 *
 *
 * 数据范围：字符串长度满足 1 \le n \le 100 \1≤n≤100
 * 输入描述：
 * 输入一个字符串
 *
 * 输出描述：
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 */
public class 表示数字 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            //把所有的数字段提取出来，前后加上星号再放回去
            String result = input.replaceAll("([0-9]+)", "*$1*");
            System.out.println(result);
        }
        sc.close();
    }

}
