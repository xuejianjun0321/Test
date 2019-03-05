package com.手撕算法.字符串相关;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 17:53
 */
public class 最长公共前缀 {

    /*
     * 求一个字符串数组的最长公共前缀
     * Write a function to find the longest common prefix string amongst an array of strings.
     */
    public class Main {
        public void main(String[] args) {
            String[] s = {"acvxx", "axc", "aaa"};
            System.out.println(longestCommonPrefix(s));
        }

        public  String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0)
                return "";
            String pre = strs[0];
            int i = 1;
            while (i < strs.length) {
                while (strs[i].indexOf(pre) != 0)  // 字符串String的indexOf方法使用
                    pre = pre.substring(0, pre.length() - 1);
                i++;
            }
            return pre;
        }
    }

}
