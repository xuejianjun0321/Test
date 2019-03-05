package com.手撕算法.字符串相关;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 17:50
 */
public class 最长公共子串 {


    /**
     * 最长公共子串
     * @param str1
     * @param str2
     * @return
     */
    int longestPublicSubstring(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] val = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i >= 1 && j >= 1) {
                        val[i][j] = val[i - 1][j - 1] + 1;
                    } else {
                        val[i][j] = 1;
                    }
                } else {
                    val[i][j] = 0;
                }
            }
        }
        // 找到val数组中的最大值
        int max = 0;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                max = Math.max(val[i][j], max);
            }
        }
        return max;
    }

}
