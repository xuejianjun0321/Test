package com.手撕算法.牛客网;
import java.util.Scanner;
/**
 * 描述
 * 计算一个浮点数的立方根，不使用库函数。
 * 保留一位小数。
 *
 * 数据范围：|val| \le 20 \∣val∣≤20
 */
public class 求解立方根 {

    /**
     * 1、利用Scanner接收键入值。
     * 2、利用牛顿迭代法求解立方根，牛顿迭代求解公式(1)所示，令键入值为y，定义函数，则本题的迭代公式如(2)，直至等式(3)成立停止迭代。
     * tips： 四舍五入保留1位小数位的做法可以利用String的静态方法format(“%.1f”, x)，其中%表示小数点前的位数，1表示保留小数点后1位，f表示转换位float型（找过一下好像没有可以转换为double的）
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (input.hasNextDouble()){
            double num = input.nextDouble();
            double x = 1.0;
            for (; Math.abs(Math.pow(x,3)-num)>1e-3; x=x-((Math.pow(x,3)-num)/(3*Math.pow(x,2))));
            System.out.println(String.format("%.1f", x));
        }
    }
}
