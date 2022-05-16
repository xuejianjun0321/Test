package com.手撕算法.牛客网;
import java.util.Scanner;
/**
 * 描述
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 *
 * 数据范围： 1 \le n \le 2^{31}-1 \1≤n≤2
 * 31
 *  −1
 * 输入描述：
 * 输入一个整数
 *
 * 输出描述：
 * 计算整数二进制中1的个数
 */
public class 查找输入整数二进制中1的个数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            String b=Integer.toBinaryString(a);
            String c=b.replaceAll("1","");
            System.out.println(b.length()-c.length());
        }
    }
}
