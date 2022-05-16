package com.手撕算法.牛客网.字符串;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 */
public class 字符串最后一个单词的长度 {

    private static void countLastWordLength(String str){
        if(!str.isEmpty()){
            String [] split = str.split(" ");
            String lastWord = split[split.length - 1];
            int length = lastWord.length();
            System.out.print(length);
        }
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String input = scan.nextLine();
            countLastWordLength(input);
        }
    }


}
