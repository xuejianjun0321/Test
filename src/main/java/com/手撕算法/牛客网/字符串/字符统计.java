package com.手撕算法.牛客网.字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 描述
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 * 数据范围：字符串长度满足 1 \le len(str) \le 1000 \1≤len(str)≤1000
 *
 * 输入描述：
 * 一个只包含小写英文字母和数字的字符串。
 *
 * 输出描述：
 * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
 */
public class 字符统计 {

    /**
     * 解本题总共分三步
     * 1.将字符串转换成字符数组。创建字符ascll码对应的整型数组，该数组长度必须大于128，
     * 字符的ascll码值就是该数组的下标，遍历字符数组，字符每出现一次对应ascll下标的整数就加一。
     * 2.找出该整型数组的最大值。
     * 3.在整型数组中匹配max，找到则将该整数下标对应的字符加入可变字符序列，max自减直至max为零。
     * （本题无需考虑字符个数相同的情况，因为字符ascll码对应的整型数组本来就是排好的）
     * 源代码
     */
    public static void main(String[] args)
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        try{
            while((str=br.readLine())!=null)
            {
                System.out.println(count(str).toString());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static StringBuilder count(String str)
    {
        char[] strArray=str.toCharArray();
        int[] chArray=new int[129];
        //字符对应ascll码值下标元素自增来统计数量
        for(char i:strArray)
            chArray[(int)i]++;
        int max=0;
        //找出字符数量最多的ascll码值
        for(int i=0;i<chArray.length;i++)
            if(max<chArray[i])
                max=chArray[i];
        StringBuilder sb=new StringBuilder();
        //按数量从大到小添加到可变字符序列sb
        while(max!=0)
        {
            for(int i=0;i<chArray.length;i++)
                if(chArray[i]==max)
                    sb.append((char)i);
            max--;
        }
        return sb;
    }
}

