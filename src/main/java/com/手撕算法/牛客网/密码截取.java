package com.手撕算法.牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，
 * 比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。
 * 比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
 * 因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），
 * Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 */
public class 密码截取 {

    /**
     * 方法二：动态规划
     * 解题思路：
     *
     * 对于最值问题，往往可以采用动态规划思想降低时间复杂度和状态压缩，采用空间换时间的思想
     *
     * 算法流程：
     *
     * 确定状态：对比的两个字符索引起始和终止索引位置
     *
     * 定义 dp 数组：字符串s的 i 到 j 索引位置的字符组成的子串是否为回文子串
     *
     * 状态转移: 如果左右两字符相等, 同时[l+1...r-1]范围内的字符是回文子串, 则 [l...r] 也是回文子串
     *
     * 状态转移的同时，不断更新对比的子串长度，最终确定最长回文子串的长度
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            System.out.println(validLen(s));
        }
        br.close();
    }

    public static int validLen(String s) {
        int len = s.length();
        // 状态：对比的两个字符索引起始和终止索引位置
        // 定义: 字符串s的i到j字符组成的子串是否为回文子串
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        // base case
        for(int i = 0; i < len - 1; i++) {
            dp[i][i] = true;
        }

        for(int r = 1; r < len; r++) {
            for(int l = 0; l < r; l++) {
                // 状态转移：如果左右两字符相等,同时[l+1...r-1]范围内的字符是回文子串
                // 则 [l...r] 也是回文子串
                if(s.charAt(l) == s.charAt(r) && (r-l <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    // 不断更新最大长度
                    res = Math.max(res, r - l + 1);
                }
            }
        }
        return res;
    }
}
