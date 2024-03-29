package com.手撕算法.牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 *
 *
 * 数据范围：输入的小球初始高度满足 1 \le n \le 1000 \1≤n≤1000  ，且保证是一个整数
 *
 * 输入描述：
 * 输入起始高度，int型
 *
 * 输出描述：
 * 分别输出第5次落地时，共经过多少米以及第5次反弹多高。
 * 注意：你可以认为你输出保留六位或以上小数的结果可以通过此题。
 */
public class 求小球落地5次后所经历的路程和第5次反弹的高度 {

    /**
     * 方法一：模拟
     * 具体方法
     * 遍历落地次数，第一次走过了落下高度这么多距离，然后弹起高度降低一半，然后走了弹起的高度这么多距离，完成一次循环，如果555个循环，累加距离，不断降低高度。
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = bf.readLine()) != null){//多组输入
            double h = Double.parseDouble(s);//记录总的
            double temp = h/2;//弹跳多高
            for(int i=1;i<5;i++){
                h += temp * 2;
                temp = temp/2;
            }
            System.out.println(h);
            System.out.println(temp);
        }

    }
}

