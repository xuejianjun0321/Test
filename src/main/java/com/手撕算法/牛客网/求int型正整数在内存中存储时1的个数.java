package com.手撕算法.牛客网;

import java.util.Scanner;
/**
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 *
 * 数据范围：保证在 32 位整型数字范围内
 */
public class 求int型正整数在内存中存储时1的个数 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();    //读取数字
        int n = 0;    //计数变量
        for(int i=0; i < 32; i++){
            if((num&1) == 1)    //如果末位为1则计数
                n++;
            num = num >>> 1;    //无符号右移
        }
        System.out.println(n);
    }

}
