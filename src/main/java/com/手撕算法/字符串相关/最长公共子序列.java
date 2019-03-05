package com.手撕算法.字符串相关;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 17:49
 */
public class 最长公共子序列 {
    /**
     * 最长公共子序列，返回值为长度
     * @param x
     * @param y
     * @return
     */
    int longestPublicSubSequence(String x, String y){
        if(x.length() == 0 || y.length() == 0){
            return 0;
        }
        if(x.charAt(0) == y.charAt(0)){
            return 1 + longestPublicSubSequence(x.substring(1), y.substring(1));
        }else{
            return Math.max(longestPublicSubSequence(x.substring(1), y.substring(0)),
                    longestPublicSubSequence(x.substring(0), y.substring(1)));
        }
    }


    int getLCS(String str, String str2){

        int n1 = str.length();
        int n2 = str2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(str.charAt(i-1)==str2.charAt(j-1)){ //此处应该减1.
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }


}
