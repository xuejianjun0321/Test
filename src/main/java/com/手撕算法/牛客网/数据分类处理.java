package com.手撕算法.牛客网;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/**
 * 描述
 * 信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
 *
 * 采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。
 *
 * 数据范围：1 \le I,R \le 100 \1≤I,R≤100  ，输入的整数大小满足 0 \le val \le 2^{31}-1\0≤val≤2
 * 31
 *  −1
 * 输入描述：
 * ﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~(2^31)-1，序列个数不限
 *
 * 输出描述：
 * ﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I：
 *
 * I整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I为231，那么I包含了R<i>，条件满足 。
 *
 * 按R<i>从小到大的顺序:
 *
 * (1)先输出R<i>；
 *
 * (2)再输出满足条件的I的个数；
 *
 * (3)然后输出满足条件的I在I序列中的位置索引(从0开始)；
 *
 * (4)最后再输出I。
 *
 * 附加条件：
 *
 * (1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I，索引大的需要过滤掉
 *
 * (2)如果没有满足条件的I，对应的R<i>不用输出
 *
 * (3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)
 *
 *
 *
 * 序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
 *
 * 序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
 *
 * 输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
 *
 * 说明：
 *
 * 30----后续有30个整数
 *
 * 3----从小到大排序，第一个R<i>为0，但没有满足条件的I，不输出0，而下一个R<i>是3
 *
 * 6--- 存在6个包含3的I
 *
 * 0--- 123所在的原序号为0
 *
 * 123--- 123包含3，满足条件
 */
public class 数据分类处理 {
    public static void main(String[] args){
        /*
         根据题解可知：整数序列I 和 规则整数序列R
         1、是根据R中元素到I序列中进行匹配查询并将I序列中出现的R[i]的索引(index)和I[i]的值进行记录
         2、定义集合用于记录待查找条件R[i]和R[i]出现的次数(count),最后将第一步得到的集合放进来即可，此处也可使用StringBuffer
         */
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int In = scanner.nextInt(); //整数序列I的个数
            String[] I_arr =  new String[In];
            for(int i=0;i<In;i++){
                I_arr[i]= String.valueOf(scanner.nextInt());
            }

            int Rn = scanner.nextInt();//规则整数序列R的个数
            Set<Integer> R_set = new TreeSet<>();//使用TreeSet进行排序和去重
            for(int i = 0; i<Rn; i++){
                R_set.add(scanner.nextInt());
            }

            List<Integer> I_list = new ArrayList<>();//用于存储整数序列I
            List<Integer> R_list = new ArrayList<>();//用于存储规则整数序列R
            for(int item : R_set){
                int count = 0;//统计R中元素在I中出现的次数
                for(int i =0; i<I_arr.length; i++){
                    if(I_arr[i].contains(String.valueOf(item))){
                        count++;
                        I_list.add(i);
                        I_list.add(Integer.valueOf(I_arr[i]));
                    }
                }
                if(count>0){
                    R_list.add(item);
                    R_list.add(count);
                    R_list.addAll(I_list);
                }
                I_list.clear();
            }
            System.out.print(R_list.size()+" ");
            for(Integer i:R_list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
