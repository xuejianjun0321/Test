package com.手撕算法.牛客网;
import java.util.Scanner;
/**
 * 描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 *
 * 数据范围：输入的数据满足 4 \le n \le 1000 \4≤n≤1000
 * 输入描述：
 * 输入一个大于2的偶数
 *
 * 输出描述：
 * 从小到大输出两个素数
 */
public class 查找组成一个偶数最接近的两个素数 {

    /**
     * 方法一：穷举
     * 解题思路：
     *
     * 对于一个数字，我们可以从2遍历到n，寻找两个加数都是素数的情况，然后比较素数之间的差值，把要输出的变量更新为更小的差值及这两个变量，最后枚举完得到就是差值最小的两个素数。
     *
     * 算法流程：
     *
     * 从2开始穷举，直到num
     * 如果 isPrime(i) && isPrime(num - i)判断是否素数后，保存两数之差最小的两个元素
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            solution(num);
        }
    }

    private static void solution(int num) {
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        // 从2开始穷举
        for(int i = 2; i < num; i++) {
            if(isPrime(i) && isPrime(num - i)) {
                // 保存最接近的两个素数
                if(Math.abs(num - i - i) < min) {
                    res[0] = i;
                    res[1] = num - i;
                    min = Math.abs(num - i - i);
                }
            }
        }
        System.out.println(res[0] + "\n" + res[1]);
    }
    // 判断是否素数
    private static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
