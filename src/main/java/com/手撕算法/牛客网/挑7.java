package com.手撕算法.牛客网;
import java.util.Scanner;
/**
 * 描述
 * 输出 1到n之间 的与 7 有关数字的个数。
 * 一个数与7有关是指这个数是 7 的倍数，或者是包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）
 *
 * 数据范围： 1 \le n \le 30000 \1≤n≤30000
 * 输入描述：
 * 一个正整数 n 。( n 不大于 30000 )
 *
 * 输出描述：
 * 一个整数，表示1到n之间的与7有关的数字个数。
 */
public class 挑7 {
    /**
     * 挑7
     * 就两种 1 能整除, 则对7取余==0,
     * 2 不能整除,则转化成字符串,看里面是否包含7
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int sum=0;
            for(int i = 1;i<=n;i++){
                if(i%7==0){
                    sum++;
                }else{
                    String s = String.valueOf(i);
                    if(s.contains("7")){
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
