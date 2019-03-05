package com.手撕算法.Others;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级台阶总共有多少种跳法？
 * 分析：当n = 1， 只有1中跳法；当n = 2时，有2种跳法；当n = 3 时，有3种跳法；当n = 4时，有5种跳法；当n = 5时，有8种跳法；.......规律类似于Fibonacci数列：

 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 15:48
 */
public class 青蛙跳台阶问题 {

    /** 递归实现 */
    public int Fibonacci(int n){
        if(n<=2)
            return n;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    /** 非递归 */
    public int jumpFloor(int number) {
        if(number<=2)
            return number;
        int jumpone=2; // 离所求的number的距离为1步的情况，有多少种跳法
        int jumptwo=1; // 离所求的number的距离为2步的情况，有多少种跳法
        int sum=0;
        for(int i=3;i<=number;i++){
            sum=jumptwo+jumpone;
            jumptwo=jumpone;
            jumpone=sum;
        }
        return sum;
    }

    /**
     * 青蛙变态跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 解题思路：
     *
     * 先跳到n-1级，再一步跳到n级，有f(n-1)种；
     * 先跳到n-2级，再一步跳到n级，有f(n-2)种；
     * 先跳到n-3级，再一步跳到n级，有f(n-3)种；
     * 。。。。。。
     * 先跳到第1级，再一步跳到n级，有f(1)种；
     * 所以：
     * f(n)=f(n-1)+f(n-2)+f(n-3)+···+f(1)
     * f(n-1)=f(n-2)+f(n-3)+···+f(1)
     * 推出f(n)=2*f(n-1)
     * @param num
     * @return
     */
    public int jumpFloor2(int num) {
        if(num<=2)
            return num;
        int jumpone=2; // 前面一级台阶的总跳法数
        int sum=0;
        for(int i=3;i<=num;i++){
            sum = 2*jumpone;
            jumpone = sum;
        }
        return sum;
    }
}
