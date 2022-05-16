package com.手撕算法.牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 描述
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 *
 * 数据范围：每组数据长度满足 1 \le n \le 200 \1≤n≤200  ， 数据大小满足 1 \le val \le 350 \1≤val≤350
 */
public class Redraiment的走法 {
    /**
     * 方法一：暴力用动态规划
     * 具体做法
     * 看到题目我们可以将其理解为求解最长递增子序列的问题，显然就是dp的问题，dp[i]表示到元素i结尾时，最长的子序列的长度。
     *
     * 如下例子[2 5 1 5 4 5]
     */
    public static int count(int []nums){
        int []dp = new int[nums.length+1];
        //初始化为1
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 1;i < nums.length;++i){
            for(int j = 0;j < i;++j){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
                max = Math.max(dp[i],max);
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = bf.readLine()) != null){
            int len = Integer.parseInt(str);
            int[] nums = new int[len];
            String[] split = bf.readLine().split(" ");
            for(int i = 0;i < len;++i){
                nums[i] = Integer.parseInt(split[i]);
            }
            System.out.println(count(nums));
        }
    }
}
