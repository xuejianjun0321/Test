package com.手撕算法.牛客网;

import java.util.Scanner;
/**
 * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
 * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
 * 数据范围：输入的正整数满足 1 \le n \le 100 \1≤n≤100
 *
 * 注意：本题存在多组输入。输入的 0 表示输入结束，并不用输出结果。
 */
public class 汽水瓶 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int bottle = sc.nextInt();
            if(bottle==0){
                break;
            }
            System.out.println(bottle/2);
        }
    }

}
