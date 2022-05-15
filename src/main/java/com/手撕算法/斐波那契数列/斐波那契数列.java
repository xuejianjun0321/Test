package com.手撕算法.斐波那契数列;

/**
 * @Description
 * @ClassName 斐波那契数列
 * @Author jinling
 * @date 2020.07.28 16:00
 */
public class 斐波那契数列 {

  /**
   * 斐波那契数列源于数学家列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入的计算问题。假设某种兔子兔子，出生第一个月变成大兔子，大兔子再过一个月能生下一对小兔子，且一年内不会发生死亡。现有一对小兔子，请问一年后有多少只兔子？
   *
   * 分析这个数列其实是有规律的
   * 第一个月：一对小兔子
   * 第二个月：一对大兔子
   * 第三个月：一对大兔子+一对小兔子
   * 第四个月：两对大兔子+一对小兔子
   * …
   * …
   * 仔细分析：
   * 数列如下 1 1 2 3 5 8 13 21
   * 前面两位的和都是第三位的结果
   * 1+1 = 2
   * 1+2 = 3
   * 2+3 = 5
   * 3+5 = 8
   * 5+8 = 13
   * 8+13= 21
   * ————————————————
   */

  public static void main(String[] args) {
    //通过递归实现斐波那契数列的计算
    //1 1 2 3 5 8 13 21
    System.out.println(fun(8));
    //通过非递归方法实现斐波那契数列的计算
    fun2(8);
  }
  public static void fun2(int z ) {
    int [] arr = new int[z];
    arr[0]=1;
    arr[1]=1;
    for(int j =2; j<arr.length;j++) {
      arr[j] = arr [j-2] + arr[j-1];
    }
    System.out.println(arr[arr.length-1]);
  }

  /**
   * 通过递归实现斐波那契数列的计算
   */
  public static int fun(int  i ) {
    if(i == 1) {
      return 1;
    }else if(i == 2) {
      return 1;
    }else {
      return fun(i-2)+fun(i-1);
    }
  }

}
