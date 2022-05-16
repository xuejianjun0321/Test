package com.手撕算法.牛客网;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 描述
 * 在命令行输入如下命令：
 *
 * xcopy /s c:\\ d:\\e，
 *
 * 各个参数如下：
 *
 * 参数1：命令字xcopy
 *
 * 参数2：字符串/s
 *
 * 参数3：字符串c:\\
 *
 * 参数4: 字符串d:\\e
 *
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 *
 *
 * 解析规则：
 *
 * 1.参数分隔符为空格
 * 2.对于用""包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s "C:\\program files" "d:\"时，参数仍然是4个，第3个参数应该是字符串C:\\program files，而不是C:\\program，注意输出参数时，需要将""去掉，引号不存在嵌套情况。
 * 3.参数不定长
 *
 * 4.输入由用例保证，不会出现不符合要求的输入
 * 数据范围：字符串长度：1\le s\le 1000\1≤s≤1000
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入一行字符串，可以有空格
 *
 * 输出描述：
 * 输出参数个数，分解后的参数，每个参数都独占一行
 */
public class 参数解析 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            ArrayList<String> list = new ArrayList();
            boolean flag = false;
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c=='"'){
                    //遇到第一个引号 flag为true,第二个引号 flag为false
                    flag = flag?false:true;
                    continue;//继续遍历下一个字符
                }
                //如果c是空格 ,且flag为false时,即没有引号 或已经是第二个引号结束
                if(c==' ' && !flag){
                    list.add(sb.toString());//往集合中添加当前拼接到的字符串
                    sb = new StringBuilder();//置空  重新遍历下一个字符
                }else{
                    //即 不是引号 也不是第二种逻辑
                    sb.append(c);
                }
            }
            //最后遍历结束 没有空格或引号,需要再加上sb 打印出数组的长度,即几个命令
            list.add(sb.toString());
            System.out.println(list.size());
            //打印出命令
            for(String s1 : list){
                System.out.println(s1);
            }
        }
    }
}
