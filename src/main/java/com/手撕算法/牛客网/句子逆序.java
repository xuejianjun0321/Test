package com.手撕算法.牛客网;

import java.util.Scanner;
/**
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 *
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 */
public class 句子逆序 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        String s[]=str.split(" ");
        for(int i=s.length-1;i>=0;i--)
            if(i!=0)
                System.out.print(s[i]+" ");
            else
                System.out.print(s[i]);
    }

}
