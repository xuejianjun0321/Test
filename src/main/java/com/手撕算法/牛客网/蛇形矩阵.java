package com.手撕算法.牛客网;

import java.util.Scanner;
/**
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 例如，当输入5时，应该输出的三角形为：
 *
 * 1 3 6 10 15
 *
 * 2 5 9 14
 *
 * 4 8 13
 *
 * 7 12
 *
 * 11
 */
public class 蛇形矩阵 {

    /**
     * 解题思路：找到数组下标的关系，按1、2、3……的顺序依次赋值。
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();    //读入正整数n

            int[][] result = new int[n][];    //建立数组（n行）
            int t = 1;    //记录依次赋予的数组值
            for(int i=0; i < n; i++){
                result[i] = new int[n-i];    //数组第i行有n-i个元素
                for(int j=0; j < i+1; j++){    //对第i个对角线赋值
                    result[i-j][j] = t;
                    t++;
                }
            }

            //输出数组值
            for(int[] a : result){
                for(int a1 : a)
                    System.out.print(a1 + " ");
                System.out.println();
            }
        }
    }
}
