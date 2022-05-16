package com.手撕算法.牛客网;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 * 数据范围：1\le n\le 10\1≤n≤10
 * 进阶：时间复杂度：O(n!)\O(n!) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 第一行输入一个正整数N（0 < N <= 10），第二行包括N个正整数，范围为1到10。
 *
 * 输出描述：
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 */
public class 火车进站 {

    // 思路：主要思想是递归，之所以产生很多方案的原因就是，每次进来一辆火车后，我们将其压入栈中，然后我们可以有两种选择，一是不弹出，二是弹出；
// 对于第二种弹出元素，弹出的个数的范围取决于当前栈中元素的个数，所以遍历每种情况，在遍历每种情况的时候再递归到下一辆火车
    static Deque<Integer> stack;
    static int[] nums, outNums;
    static int n;
    static List<String> res;
    public static void main(String[] args) {
        // 完成输入
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        nums = new int[n];
        for (int i=0; i<n; i++) nums[i] = in.nextInt();
        // outNums是用来记录当前递归中，已经出站的火车编号； stack是记录当前车站中还有哪些火车；
        // res是记录所有结果并进行排序，因为题目要求所有方案以字典序排序输出，所以没办法必须加
        outNums = new int[n];
        stack = new LinkedList<>();
        res = new ArrayList<>();
        // 开始遍历
        dfs(0, 0);
        // 对所有方案排序，并输出
        Collections.sort(res);
        for (String str:res) System.out.println(str);
    }

    // i代表已经递归到了第i辆火车，cnt代表已经已经出站的火车数量，即是outNums的下标
    public static void dfs(int i, int cnt) {
        // 这个tmp栈很重要，这是保证dfs返回时，stack中的元素和进来时一样
        Deque<Integer> tmp = new LinkedList<>();
        // 压入当前火车
        stack.push(nums[i]);

        // 当递归到最后一辆火车时，我们只需要将其压入栈中，这时所能做的只有弹出栈中所有元素，并将其添加到outNums数组中
        if (i==n-1) {

            // 弹出栈中所有元素
            while (stack.size() > 0) {
                tmp.push(stack.peek());
                outNums[cnt++] = stack.pop();
            }
            // 这里>1是因为stack中本身不含有nums[i]
            while (tmp.size() > 1) stack.push(tmp.pop());
            // 将当前方案以字符串形式保存到res中
            StringBuilder sb = new StringBuilder();
            for (int outNum:outNums) sb.append(outNum).append(" ");
            res.add(sb.toString());
        }
        // 如果没有递归到最后一辆火车，那么在将当前火车编号压入栈后，有很多选择，这也就产生了很多方案
        // 一种就是继续压；还有一种就是开始弹出元素，弹出元素个数范围是[0, size]（包含两边界），那么就需要依次遍历
        else {
            int size = stack.size();
            // 继续压
            dfs(i+1, cnt);
            // 开始弹出元素
            for (int j=0; j<size; j++) {
                tmp.push(stack.peek());
                outNums[cnt++] = stack.pop();
                dfs(i+1, cnt);
            }
            // 这里>1是因为stack中本身不含有nums[i]，
            while (tmp.size() > 1) stack.push(tmp.pop());
        }
    }
}

