package com.手撕算法.牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 描述
 * IPV4地址可以用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此正号不需要出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 *
 * 现在需要你用程序来判断IP是否合法。
 *
 * 数据范围：数据组数：1\le t\le 18\1≤t≤18
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 */
public class 合法IP {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            String[] s = str.split("\\.");
            boolean flag = true;
            if (s.length == 4) {
                for (String s1 : s) {
                    try {
                        int i = Integer.parseInt(s1);
                        if(i < 0 || i > 255){
                            flag = false;
                            break;
                        }
                    } catch (NumberFormatException err) {
                        flag = false;
                        break;
                    }
                }
            }else{
                flag = false;
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}