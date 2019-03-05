package com.手撕算法.常见排序算法;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 14:10
 */
public class Sort {

    /**
     * 冒泡排序
     * @param nums 数组
     */
    public void bubbleSort(int [] nums){
        //校验数组
        if (nums == null || nums.length <= 1){
            return;
        }

        for (int i=0; i<nums.length -1; i++){
            for (int j= i+1 ; j< nums.length ; j++){
                if (nums[i] > nums[j]){
                    nums[i] = nums[i]+nums[j];
                    nums[j] = nums[i] - nums[j];
                    nums[i] = nums[i] - nums[j];
                }
            }
        }
    }

    /**
     * 冒泡算法最优解
     *
     * @param nums 待排序的数组
     */
    public static void bubbleSort3(int[] nums) {
        int j, k;
        int flag = nums.length;// flag来记录最后交换的位置，也就是排序的尾边界

        while (flag > 0) {// 排序未结束标志
            k = flag;// k 来记录遍历的尾边界
            flag = 0;

            for (j = 1; j < k; j++) {
                if (nums[j - 1] > nums[j]) {// 前面的数字大于后面的数字就交换
                    // 交换a[j-1]和a[j]
                    int temp;
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;

                    // 表示交换过数据;
                    flag = j;// 记录最新的尾边界.
                }
            }
        }
    }

    /**
     * 快速排序
     * @param nums 数组
     */
    public static void quickSort(int [] nums){
        qSort(nums, 0, nums.length - 1);
    }

    private static void qSort(int [] arr, int low , int high){
        if (low < high){
            int pivot = partition(arr, low, high);              // 将数组分为两部分
            qSort(arr, low, pivot - 1);                   // 递归排序左子数组
            qSort(arr, pivot + 1, high);                  // 递归排序右子数组
        }
    }

    private static int partition(int [] arr,int low ,int high ){
        // 枢轴记录
        int pivot = arr[low];
        while (low<high){
            while (low < high && arr[high] >= pivot)
                --high;
                // 交换比枢轴小的记录到左端
                arr[low] = arr[high];

            while (low < high && arr[low] <= pivot )
                ++ low;
                // 交换比枢轴小的记录到右端
                arr[high] = arr[low];
        }
        // 扫描完成，枢轴到位
        arr[low] = pivot;
        // 返回的是枢轴的位置
        return low;
    }

}
