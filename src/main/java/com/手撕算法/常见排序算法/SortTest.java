package com.手撕算法.常见排序算法;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 14:18
 */
public class SortTest {

    public static void main(String [] args){

        /************************ 测试冒泡排序 **********************/
        int [] nums = {1,4,2,-2,7,0,-11};
        Sort sort = new Sort();
        sort.bubbleSort(nums);
        // 输出测试结果
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();

        /************************ 测试快速排序 **********************/

        // 测试用例2：验证多个相同的数是否满足要求
        nums = new int[]{1, 1, 5, 7, 7, 3, 1};
        sort.quickSort(nums);
        // 输出测试结果
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

}
