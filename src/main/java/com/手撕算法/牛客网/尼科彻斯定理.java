package com.手撕算法.牛客网;
import java.util.Scanner;

/**
 * 描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 *
 * 1^3=1
 *
 * 2^3=3+5
 *
 * 3^3=7+9+11
 *
 * 4^3=13+15+17+19
 *
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 数据范围：1\le m\le 100\1≤m≤100
 * 进阶：时间复杂度：O(m)\O(m) ，空间复杂度：O(1)\O(1)
 */
public class 尼科彻斯定理 {

    /**
     * 高中的我们看到这个题的一瞬间，一定会觉得这是个弱智题。然而现在的我，想了好久。。
     * 题目的意思是已知等差数列和 图片说明 为 图片标题 ，项数n为m，公差d为2，求首项a1 ：
     * 图片说明
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            long sum = (long)Math.pow(n,3);
            int a1 = (int)sum/n - (n - 1);
            StringBuilder sb = new StringBuilder(Integer.toString(a1));
            for(int i = 1; i < n; i++){
                a1 = a1 + 2;
                sb.append("+");
                sb.append(a1);
            }
            System.out.println(sb);
        }
    }
}
