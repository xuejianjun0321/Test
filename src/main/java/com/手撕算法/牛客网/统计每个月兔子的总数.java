package com.手撕算法.牛客网;

import java.util.Scanner;
/**
 * 有一种兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子。
 * 例子：假设一只兔子第3个月出生，那么它第5个月开始会每个月生一只兔子。
 * 一月的时候有一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
 * 数据范围：输入满足 1 \le n \le 31 \1≤n≤31
 */
public class 统计每个月兔子的总数 {

    /**
     * 方法一：递推
     * 解题思路：
     *
     * 利用动态规划的思想，通过规律进行递推，找出
     *
     * 算法流程：
     *
     * 分别用三个变量表示：一、二、三月龄兔子数量，addVal 保存下个月将繁殖的兔子数量
     * 第二个月开始递推：
     * 三月龄及以上兔子总数 = 二月龄兔子总数 + 原本三月龄及以上兔子总数
     * 二月龄兔子总数 = 上个月的一月龄兔子总数
     * 一月龄（即这个月出生）兔子总数 = 上个月将繁殖的兔子数量、
     * 下个月将出生的兔子 = 下个月成为三月龄及以上的兔子数量
     * 最后返回第 N 个月的总量即可
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(solution(scanner.nextInt()));
        }

    }

    private static int solution(int month) {
        // 第一个月初始化
        // 一月龄兔子总数
        int oneMonth = 1;
        // 二月龄兔子总数
        int twoMonth = 0;
        // 三月龄及以上兔子总数
        int threeMonth = 0;
        // 下个月将繁殖的兔子数量
        int addVal = 0;
        // 第二个月开始递推, i表示第i个月
        for(int i = 2; i <= month; i++) {
            // 三月龄及以上兔子总数 = 二月龄兔子总数 + 原本三月龄及以上兔子总数
            threeMonth += twoMonth;
            // 二月龄兔子总数 = 上个月的一月龄兔子总数
            twoMonth = oneMonth;
            // 一月龄（即这个月出生）兔子总数 = 上个月将繁殖的兔子数量
            oneMonth = addVal;
            // 下个月将出生的兔子 = 下个月成为三月龄及以上的兔子数量
            addVal = twoMonth + threeMonth;
        }
        return (oneMonth + twoMonth + threeMonth);
    }
}
