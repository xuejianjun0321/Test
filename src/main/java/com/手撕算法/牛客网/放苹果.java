package com.手撕算法.牛客网;
import java.util.Scanner;
/**
 * 描述
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * 注意：如果有7个苹果和3个盘子，（5，1，1）和（1，5，1）被视为是同一种分法。
 *
 * 数据范围：0 \le m \le 10 \0≤m≤10 ，1 \le n \le 10 \1≤n≤10 。
 */
public class 放苹果 {

    /**
     * 采用递归的思想将此事件无限细分，每个事件可以分为f(m,n)=f(m-n,n)+f(m,n-1);f(m-n,n)是当苹果数大于等于盘子数的情况，f(m,n-1)是当苹果数小于盘子数的情况。当此事件分到苹果数为0或苹果数为1或盘子数为1的时候返回1，当苹果数小于0或盘子数小于等于0返回0.
     */
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt())
        {
            System.out.println(count(sc.nextInt(),sc.nextInt()));
        }
        sc.close();
    }
    public static int count(int m,int n)
    {
        if(m<0||n<=0)
            return 0;
        //细分到苹果数为一或盘子数为一的情况返回一
        if(m==1||n==1||m==0)
            return 1;
        //将此事件无线细分
        return count(m,n-1)+count(m-n,n);
    }
}