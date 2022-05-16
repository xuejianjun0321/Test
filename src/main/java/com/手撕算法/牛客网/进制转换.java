package com.手撕算法.牛客网;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示
 */

import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
        }
    }

}
