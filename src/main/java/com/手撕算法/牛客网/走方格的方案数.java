package com.手撕算法.牛客网;
import java.util.Scanner;
/**
 * 描述
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）从棋盘左上角出发沿着边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 *
 * 注：沿棋盘格之间的边缘线行走
 *
 * 数据范围： 1 \le n,m \le 8 \1≤n,m≤8
 */
public class 走方格的方案数 {

    //递归思路，每一种m,n的方块，就相当于m-1,n 和m,n-1的方块两种方案加起来
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(cal(m,n));
        }

    }
    private static int cal(int m,int n){
        if(m==1 || n== 1){
            return m+n;
        }
        return cal(m-1,n)+cal(m,n-1);
    }
}
