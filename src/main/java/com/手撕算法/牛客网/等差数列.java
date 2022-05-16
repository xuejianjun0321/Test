package com.手撕算法.牛客网;
import java.util.Scanner;
/**
 * 描述
 * 等差数列 2，5，8，11，14。。。。
 * （从 2 开始的 3 为公差的等差数列）
 * 输出求等差数列前n项和
 *
 *
 * 数据范围： 1 \le n \le 1000 \1≤n≤1000
 * 输入描述：
 * 输入一个正整数n。
 *
 * 输出描述：
 * 输出一个相加后的整数。
 */
public class 等差数列 {
    //例如：1,3,5,7,9……（2n-1)。等差数列{an}的通项公式为：an=a1+(n-1)d。
//前n项和公式为：Sn=n*a1+n(n-1)d/2或Sn=n(a1+an)/2 。注意： 以上整数。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt(); //N 项
            int sum = 0;
            int a1 = 2; //首项
            int d = 3; //公差
            for(int i = 0;i<n;i++) {
                sum += a1;
                a1 = a1+d;
            }
            System.out.println(sum);
        }
    }
}
