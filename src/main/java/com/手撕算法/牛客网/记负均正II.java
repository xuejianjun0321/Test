package com.手撕算法.牛客网;
import java.util.Scanner;
/**
 * 描述
 * 输入 n 个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 * 本题有多组输入数据，输入到文件末尾。
 *
 * 数据范围：1 \le n \le 50000 \1≤n≤50000  ，其中每个数都满足 |val| \le 10^{6} \∣val∣≤10
 * 6
 *
 */
public class 记负均正II {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int temp = 0;
        int countN = 0;
        int countP = 0;
        double sum = 0.0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            temp = in.nextInt();
            if(temp<0){
                countN++;
            }else if(temp>0){
                countP++;
                sum += temp;
            }
        }
        System.out.println(countN);
        if(countP==0){
            System.out.printf("0.0");
        }else{
            System.out.printf("%.1f\n",sum/countP);
        }
    }

}
