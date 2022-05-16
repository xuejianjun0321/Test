package com.手撕算法.牛客网;
import java.util.Scanner;
/***
 * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数、左上角数和右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 *
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3，输入2则输出-1。
 *
 * 数据范围： 1 \le n \le 10^9 \1≤n≤10
 * 9
 *
 */
public class 杨辉三角的变形 {

    /**
     * 本题是找规律的题，只要往下再写几行就可以看出奇偶的规律，而且每行只需要写前几个就可以了，因为题目问的是第一个偶数的index。
     * 于是我们会发现，只有n为1，2时，没有出现偶数，剩下的按照2 3 2 4的规律每四行循环一次。
     *
     * n	1	2	3	4	5	6	7	8	9	10	11	……
     * index	-1	-1	2	3	2	4	2	3	2	4	2	……
     * 规律为：
     *
     * n	（对4求余的结果）%4	print
     * 4、8、12……	0	3
     * 5、9、13……	1	2
     * 6、10、14 ……	2	4
     * 7、11、15……	3	2
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if(num == 1 || num == 2){
                System.out.println(-1);
                continue;
            }
            else if(num % 4 == 1 || num % 4 == 3){
                System.out.println(2);
                continue;
            }
            else if(num % 4 == 0){
                System.out.println(3);
                continue;
            }
            else if(num % 4 == 2){
                System.out.println(4);
                continue;
            }
        }
    }
}
