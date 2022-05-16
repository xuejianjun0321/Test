package com.手撕算法.牛客网;

import java.util.Scanner;
/**
 * N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。
 *
 * 设KK位同学从左到右依次编号为 1，2…，K ，他们的身高分别为T_1,T_2,…,T_KT
 若存在i(1\leq i\leq K)i(1≤i≤K) 使得T_1<T_2<......<T_{i-1}<T_iT1<T2<......<Ti−1<Ti且 T_i>T_{i+1}>......>T_KTi>Ti+1>......>TK
 *  ，则称这KK名同学排成了合唱队形。
 * 通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
 * 例子：
 * 123 124 125 123 121 是一个合唱队形
 * 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
 * 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 */

public class 合唱队 {

    /**
     * 方法二：借助二分查找
     * 具体方法
     * 由于直接使用动态规划，需要两次遍历数组，借助之前求解最长递增子序列的优化思想，借助二分查找来求解。用一个num数组记录以i为终点的从左向右和从右向走的子序列元素个数。
     *
     * 举例说明： 8 186 186 150 200 160 130 197 200
     *
     * 这里给出左侧遍历的结果，右侧是同样的道理。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] left = new int[n]; //存储每个数左边小于其的数的个数
            int[] right = new int[n];//存储每个数右边小于其的数的个数
            left[0] = arr[0];
            right[n - 1] = arr[n-1];
            int num[] =new  int [n];//记录以i为终点的从左向右和从右向走的子序列元素个数
            int index = 1;//记录当前子序列的长度
            for(int i=1;i<n;i++){
                if(arr[i]>left[index-1]){
                    //直接放在尾部
                    num[i] = index;//i左侧元素个数
                    left[index++] = arr[i];//更新递增序列
                }else {
                    //找到当前元素应该放在的位置
                    int low = 0,high = index-1;
                    while(low < high){
                        int mid = (low+high)/2;
                        if(left[mid] <arr[i])
                            low = mid + 1;
                        else
                            high = mid;
                    }
                    //将所属位置替换为当前元素
                    left[low] = arr[i];
                    num[i] = low;//当前位置i的左侧元素个数
                }
            }
            index = 1;
            for(int i=n-2;i>=0;i--){
                if(arr[i]>right[index-1]){
                    num[i] += index;
                    right[index++] = arr[i];
                }else {
                    int low = 0,high = index-1;
                    while(low < high){
                        int mid = (high+low)/2;
                        if(right[mid]<arr[i])
                            low = mid+1;
                        else
                            high = mid;
                    }
                    right[low] = arr[i];
                    num[i]+=low;
                }
            }
            int max = 1;
            for (int number: num )
                max = Math.max(max,number);
            // max+1为最大的k
            System.out.println(n - max);
        }
    }
}
