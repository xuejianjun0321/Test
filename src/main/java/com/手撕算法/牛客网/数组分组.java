package com.手撕算法.牛客网;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/**
 * 描述
 * 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），不是5的倍数也不是3的倍数能放在任意一组，可以将数组分为空数组，能满足以上条件，输出true；不满足时输出false。
 *
 * 数据范围：每个数组大小满足 1 \le n \le 50 \1≤n≤50  ，输入的数据大小满足 |val| \le 500 \∣val∣≤500
 * 输入描述：
 * 第一行是数据个数，第二行是输入的数据
 *
 * 输出描述：
 * 返回true或者false
 */
public class 数组分组 {

    /**
     *
     * 先把三和五的倍数都挑出来，算好两边的和sum3和sum5，所有数总和为sum，不是3或5倍数的剩余的数放在集合中。
     * 求出target = sum/2-sum3或者target=sum/2-sum5作为目标数，看list中找能不能凑出target。
     * 在剩余集合中找target是一个dfs过程
     *
     * 终止条件，用完集合数，返回target==0
     *
     * 两种递归情况
     *
     * --选择start位置，递归找新目标数target-list.get(start)
     *
     * --不选择start位置，在start+1和以后位置找target
     * 特例：sum不是2的倍数，不可等分成两份，直接输出false
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            //根据输入计算sum3，sum5和所有数总和sum，同时把不是5和3倍数的剩余数放入集合
            List<Integer> list = new LinkedList<>();
            int n = in.nextInt();
            int sum5=0, sum3=0, sum = 0;
            for (int i = 0; i < n; i++){
                int cur = in.nextInt();//输入
                if (cur % 5 == 0){//5倍数和
                    sum5 += cur;
                }else if (cur % 3 == 0){//3倍数和
                    sum3 += cur;
                }else{//剩余加入集合
                    list.add(cur);
                }
                sum += cur;//总和
            }

            //特例，总和不是2的倍数，不可分2份和相等的数字
            if(sum%2!=0) System.out.println("false");
            else{//否则，在剩余数中找目标数字
                int target = sum/2 - sum3;//也可以是sum/2-sum5
                System.out.println(helper(list, target, 0));
            }
        }
    }

    private static boolean helper(List<Integer> list, int target, int start){
        if (start == list.size()) return target == 0;//终止条件

        //选择start位置，递归找新目标数target-list.get(start)， 或者不选择start位置，在后面位置找target
        return helper(list, target-list.get(start), start+1) || helper(list, target, start+1);
    }
}
