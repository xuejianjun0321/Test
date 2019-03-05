package com.手撕算法.字符串相关;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 17:52
 */
public class 最长递增子序列 {
    /**
     * 最长递增子序列 动态规划
     * @param num
     * @return
     */
    public static int LongestLIS(int[] num) {
        if (num.length < 1)
            return 0;
        // 定义一个memo数组memo[i]表示以num[i]结尾的序列的长度-1
        int[] memo = new int[num.length];
        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }
        // 遍历memo数组，找到最大值，并且返回max+1;
        int max = 0;
        for (int i = 0; i < memo.length; i++) {
            max = Math.max(max, memo[i]);
        }
        return max + 1;

    }
}
