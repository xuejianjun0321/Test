package com.手撕算法.牛客网.字符串;
import java.util.Scanner;
/**
 * 描述
 * 将一个字符串str的内容颠倒过来，并输出。
 *
 * 数据范围：1 \le len(str) \le 10000\1≤len(str)≤10000
 */
public class 字符逆序 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder res = new StringBuilder(input);
        System.out.println(res.reverse());
    }

}
