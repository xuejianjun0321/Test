package com.手撕算法.牛客网;
import java.util.Scanner;

/**
 * 描述
 * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 *
 * 数据范围：数据组数：1\le t\le 5\1≤t≤5 ，1\le n\le 500000\1≤n≤500000
 * 进阶：时间复杂度：O(logn)\O(logn) ，空间复杂度：O(1)\O(1)
 */
public class 求最大连续bit数 {
    /**
     * java直接用位运算&，用当前数字和1做“&”操作，如果结果是1，说明此时的二进制第一位为1，然后右移一位，直至数字为0。
     * 注意java的>>是有符号右移，也就是说，负数用>>右移的话，会在左侧补1而不是0，这就会影响最终对1的计数。所以这里我们要使用无符号右移>>>。
     * 另外题目的意思是我们需要接收一个byte数字，然而我们提交时第一个没通过的测试用例为200。很显然，byte的取值范围为-128 ~ 127，题目有些莫名其妙，直接用int来接收是没有问题的。
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//         while (in.hasNextByte()) {
//             byte num = in.nextByte();
        while(in.hasNextInt()){
            int num = in.nextInt();
            int max = 0;
            int count = 0;
            while(num != 0){
                if((num&1) == 1){
                    count++;
                    max = Math.max(max,count);
                }
                else{
                    count = 0;
                }
                num >>>= 1;
            }
            System.out.println(max);
        }
    }
}
