package com.手撕算法.数组相关;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，4，6}，则打印出这三个数字能排成的最小数字为321323。
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 15:43
 */
public class 把数组排成最小的数 {

    public String PrintMinNumber(int [] num) {
        if(num==null||num.length==0)
            return "";
        int len = num.length;
        String[] str = new String[len];
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(num[i]);
        }
        for (int i = 0; i < str.length; i++) {
            for (int j = i+1; j < str.length; j++) {
                if(compare(str[i], str[j])){
                    String temp = str[j];
                    str[j] = str[i];
                    str[i] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<str.length;i++){
            sb = sb.append(str[i]);
        }
        return sb.toString();

    }
    private boolean compare(String s1,String s2){
        int len = s1.length()+s2.length();
        String str1 = s1+s2;
        String str2 = s2+s1;
        for (int i = 0; i < len; i++) {
            if(Integer.parseInt(str1.substring(i,i+1))>Integer.parseInt(str2.substring(i,i+1)))
                return true;
            if(Integer.parseInt(str1.substring(i,i+1))<Integer.parseInt(str2.substring(i,i+1)))
                return false;
        }
        return false;
    }
}
