package com.手撕算法.牛客网;
import java.util.Scanner;

/**
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
 *
 * 矩阵的大小不超过100*100
 * 输入描述：
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 * 之后x行，每行y个整数，代表第一个矩阵的值
 * 之后y行，每行z个整数，代表第二个矩阵的值
 */
public class 矩阵乘法 {
    // 矩阵乘法
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()) {
            // 输入三个特征值
            int lamda1 = sc.nextInt();// 第一个矩阵的行
            int lamda2 = sc.nextInt();// 第一个矩阵的列 & 第二个矩阵的行
            int lamda3 = sc.nextInt();// 第二个矩阵的列
            // 声明两个数组
            int[][] matrix1 = new int[lamda1][lamda2];
            int[][] matrix2 = new int[lamda2][lamda3];
            int[][] res = new int[lamda1][lamda3];// 保存运算结果的矩阵
            for (int i = 0; i < lamda1; i++) {
                for (int j = 0; j < lamda2; j++)
                    matrix1[i][j] = sc.nextInt();
            }
            for (int i = 0; i < lamda2; i++) {
                for (int j = 0; j < lamda3; j++)
                    matrix2[i][j] = sc.nextInt();
            }
            // res[i][j] =
            int sum = 0;
            for (int i = 0; i < lamda1; i++) { // 2

                for (int j = 0; j < lamda3; j++) { // 第二个矩阵有多少列,2
                    for (int k = 0; k < lamda2; k++) { // 3
                        sum += matrix1[i][k] * matrix2[k][j]; //
//                        System.out.print(matrix1[j][k] + " "+ matrix2[k][j]);
                    }
                    res[i][j] = sum;
                    sum = 0;
                }
            }
            for (int i = 0; i < lamda1; i++)
            {
                for(int j = 0;j < lamda3;j++)
                    System.out.print(res[i][j] + " ");
                System.out.println();
            }

        }
    }
}
