package com.手撕算法.牛客网;
import java.util.Scanner;
/**
 * 描述
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 * 0即不是正整数，也不是负数，不计入计算。如果没有正数，则平均值为0。
 *
 * 数据范围： 1 \le n\ \le 2000 \1≤n ≤2000  ，输入的整数都满足 |val| \le 1000 \∣val∣≤1000
 * 输入描述：
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 *
 * 输出描述：
 * 输出负数的个数，和所有正整数的平均值。
 */
public class 记负均正 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int countNegative = 0;
            int countPositive = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int number = sc.nextInt();
                if (number < 0) {
                    countNegative++;
                } else if (number > 0){
                    sum += number;
                    countPositive++;
                }
            }
            System.out.println(countNegative + " " + String.format("%.1f", sum * 1.0 / countPositive));
        }
        sc.close();
    }
}
