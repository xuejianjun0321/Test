package com.手撕算法.牛客网.字符串;
import java.util.Scanner;

/**
 * 描述
 * 判断短字符串S中的所有字符是否在长字符串T中全部出现。
 * 请注意本题有多组样例输入。
 * 数据范围:1\le len(S),len(T)\le200\1≤len(S),len(T)≤200
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
 *
 * 输出描述：
 * 如果短字符串的所有字符均在长字符串中出现过，则输出字符串"true"。否则输出字符串"false"。
 */
public class 字符串字符匹配 {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            String[] array = a.split("");  //将 短字符串 切分并放入数组中
            //定义计数器并初始化
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (b.contains(array[i])){
                    // 循环判断 长字符串 中是否包含 短字符串中的字符
                    // 如果包含，则计数器加一
                    count++;
                }
            }
            // 当计数器大小 等于 原短字符串生成的数组长度时 ，即为 短字符串的所有字符均在长字符串中出现过
            if (count == array.length){
                System.out.println(true);
            }else {
                System.out.println(false);
            }
        }

    }
}
