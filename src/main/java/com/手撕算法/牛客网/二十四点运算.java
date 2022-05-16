package com.手撕算法.牛客网;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Scanner;
/**
 * 描述
 * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
 * <p>
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 * <p>
 * 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
 * <p>
 * 详细说明：
 * <p>
 * 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，没有括号，友情提醒，整数除法要当心，是属于整除，比如2/3=0，3/2=1；
 * 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
 * 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 * 4.输出的算式格式为4张牌通过+-四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
 * 5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24，2A 9A不能变为(2+1)*(9-1)=24
 * 6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
 * 7.因为都是扑克牌，不存在单个牌为0的情况，且没有括号运算，除数(即分母)的数字不可能为0
 * <p>
 * 数据范围：一行由4张牌组成的字符串
 */
public class 二十四点运算 {
    //初始化map,方便取得卡牌上点数；
    static void initMap(Map<String, Integer> inPutmap) {
        inPutmap.put("2", 2);
        inPutmap.put("3", 3);
        inPutmap.put("4", 4);
        inPutmap.put("5", 5);
        inPutmap.put("6", 6);
        inPutmap.put("7", 7);
        inPutmap.put("8", 8);
        inPutmap.put("9", 9);
        inPutmap.put("10", 10);
        inPutmap.put("A", 1);
        inPutmap.put("J", 11);
        inPutmap.put("Q", 12);
        inPutmap.put("K", 13);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String inPut = in.nextLine();
        String cards[] = inPut.split(" ");
        Map<String, Integer> inPutMap = new HashMap<>();
        initMap(inPutMap);
        int cardPos[] = new int[4];
        int cardPoint[] = new int[4];
        for (int i = 0; i < cards.length; ++i) {
            if (null == inPutMap.get(cards[i])) {
                //如果有joker,则返回ERROR
                System.out.println("ERROR");
                return;
            }
            cardPoint[i] = inPutMap.get(cards[i]);
        }
        Stack<String> outPut = new Stack<>();
        for (int i = 0; i < 4; ++i) {
            int temp = cardPoint[i];
            cardPos[i] = 1;
            //只要得出24点，则打印出结果
            if (get24(cardPos, cardPoint, temp, 24, cards, outPut)) {
                outPut.push(cards[i]);
                //从栈中取出结果并打印
                while (!outPut.empty()) {
                    System.out.print(outPut.pop());
                }
                return;
            }
            cardPos[i] = 0;
        }
        System.out.println("NONE");
    }

    static boolean get24(int pos[], int cardPoint[], int result, int required, String cards[], Stack<String> outPut) {
        boolean visited = true;
        for (int p : pos) {
            if (p == 0) visited = false;
        }
        if (visited) {
            return result == required;
        }
        for (int i = 0; i < 4; ++i) {
            if (pos[i] == 0) {
                int num = cardPoint[i];
                pos[i] = 1;
                if (get24(pos, cardPoint, result - num, 24, cards, outPut)) {
                    outPut.push("-" + cards[i]);
                    return true;
                }
                if (get24(pos, cardPoint, result + num, 24, cards, outPut)) {
                    outPut.push("+" + cards[i]);
                    return true;
                }
                if (get24(pos, cardPoint, result * num, 24, cards, outPut)) {
                    outPut.push("*" + cards[i]);
                    return true;
                }
                if (result % num == 0) {
                    if (get24(pos, cardPoint, result / num, 24, cards, outPut)) {
                        outPut.push("/" + cards[i]);
                        return true;
                    }
                }
                //回溯
                pos[i] = 0;
            }
        }
        return false;
    }
}