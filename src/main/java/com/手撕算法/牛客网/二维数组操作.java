package com.手撕算法.牛客网;
import java.util.Scanner;

/**
 * 描述
 * 有一个m*n\m∗n 大小的数据表，你会依次进行以下5种操作：
 * 1.输入m\m 和n\n ，初始化m*n\m∗n 大小的表格。
 * 2.输入x_1x   1  、y_1y  1 、x_2x   2 、y_2y   2 ，交换坐标在(x_1,y_1)(x  1  ,y  1 )和(x_2,y_2)(x 2  ,y  2 )的两个数。
 * 3.输入x\x ，在第x\x 行上方添加一行。
 * 4.输入y\y ，在第y\y 列左边添加一列。
 * 5.输入x\x 、y\y ，查找坐标为(x,y)\(x,y) 的单元格的值。
 * 请编写程序，判断对表格的各种操作是否合法。
 *
 * 详细要求:
 *
 * 1.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误。
 * 2.对于插入操作，如果插入后行数或列数超过9了则应返回错误。如果插入成功了则将数据表恢复至初始化的m*n\m∗n 大小，多出的数据则应舍弃。
 * 3.所有输入坐标操作，对m*n\m∗n 大小的表格，行号坐标只允许0~m-1，列号坐标只允许0~n-1。超出范围应该返回错误。
 *
 * 本题含有多组样例输入！行列从0开始标号
 * 数据范围：数据组数：1\le t\le 5\1≤t≤5
 * 进阶：时间复杂度：O(1)\O(1) ，空间复杂度：O(1)\O(1)
 */
public class 二维数组操作 {

    /**
     * 二维数组操作 - 简单
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r, c, r1, c1, r2, c2, ri, ci, rt, ct;
        while (sc.hasNext()) {
            r = sc.nextInt();
            c = sc.nextInt();
            r1 = sc.nextInt();
            c1 = sc.nextInt();
            r2 = sc.nextInt();
            c2 = sc.nextInt();
            ri = sc.nextInt();
            ci = sc.nextInt();
            rt = sc.nextInt();
            ct = sc.nextInt();
            if (r <= 9 && c <= 9) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            if ((r1 < r && r2 < r) && (c1 < c && c2 < c)) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            //插入行和列的时候,要注意,只有在原来的行和列是小于9的情况下才能插入
            if (ri < r && r < 9) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            if (ci < c && c < 9) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            //无论怎么插入行和列, 表格永远是初始的规格大小
            if (rt < r && ct < c) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
        sc.close();
    }

}
