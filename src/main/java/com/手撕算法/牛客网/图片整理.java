package com.手撕算法.牛客网;

import java.util.Scanner;
/**
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过代码解决。
 * Lily使用的图片使用字符"A"到"Z"、"a"到"z"、"0"到"9"表示。
 */
public class 图片整理 {
    /**
     * 开一个数组，下标对应字符的ASCII码，存储字符出现的次数，最后按数组顺序输出。
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int a[]=new int[128];
            String str=in.next();
            for(int i=0;i<str.length();i++){
                int k=str.charAt(i);//统计出现次数
                a[k]++;
            }
            for(int j=48;j<a.length;j++){//从'0'开始输出
                if(a[j]!=0)
                    for(int b=0;b<a[j];b++)
                        System.out.print((char)j);
            }
            System.out.println();
        }
    }

}
