package com.手撕算法.牛客网;
import java.util.Scanner;

/**
 * 描述
 * 找出给定字符串中大写字符(即'A'-'Z')的个数。
 * 数据范围：字符串长度：1\le |s|\le 250\1≤∣s∣≤250
 * 字符串中可能包含空格或其他字符
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n)
 */
public class 统计大写字母个数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(in.nextLine().replaceAll("[^A-Z]","").length());
        }
    }
}
