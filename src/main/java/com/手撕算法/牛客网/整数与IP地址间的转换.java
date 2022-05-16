package com.手撕算法.牛客网;

import java.util.Scanner;
/**
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 *
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *
 * 数据范围：保证输入的是合法的 IP 序列
 */
public class 整数与IP地址间的转换 {

    /**
     * 方法一:通过二进制进行转换
     * 具体方法
     * 在问题中有两个转换过程，一个是将ip地址转换为长整数，一个是将长整数转换为ip地址，通过题目中的转换过程进行转换。 对于ip地址转换成长整数： 1、将ip地址切割成四段数字 2、每段数字用8位2二进制数字表示 3、将四段二进制数字组合 4、将二进制数字转换成长整数 对于长整数转换成ip地址则步骤相反 1、将长整数转换成32位二进制数字 2、将32位二进制数字进行切割 3、将每段的二进制数字转换为十进制数字 4、形成ip地址
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            if(s.contains(".")){
                System.out.println(ip2num(s));
            }else{
                System.out.println(num2ip(Long.parseLong(s)));
            }
        }
    }

    public static long ip2num(String ip){
        String[] iip = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++){
            int num = Integer.parseInt(iip[i]);  // 拆分
            String num2 = Integer.toBinaryString(num);  //转换为二进制
            while(num2.length()<8){
                num2 = "0" + num2;  // 拼接
            }
            sb.append(num2);
        }
        return Long.parseLong(sb.toString(), 2);  // 转化为10进制
    }

    public static String num2ip(long num){
        String num2 = Long.toBinaryString(num);  //转换为2进制
        while(num2.length()<32){
            num2 = "0" + num2;
        }
        String[] ans = new String[4];
        for(int i=0; i<4; i++){
            String s = num2.substring(8*i, 8*i+8);  //拆分
            s = Integer.toString(Integer.parseInt(s, 2));  //转化为10进制
            ans[i] = s;
        }
        return String.join(".", ans);  //拼接
    }
}
