package com.手撕算法.牛客网;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

/**
 * 描述
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 *
 * 数据范围：表达式计算结果和过程中满足 |val| \le 1000 \∣val∣≤1000  ，字符串长度满足 1 \le n \le 1000 \1≤n≤1000
 *
 * 输入描述：
 * 输入一个算术表达式
 *
 * 输出描述：
 * 得到计算结果
 */
public class 四则运算 {

    public static void main(String[] args) throws ScriptException {
        Scanner scan = new  Scanner(System.in);
        String input = scan.nextLine();
        input = input.replace("[","(");
        input = input.replace("{","(");
        input = input.replace("}",")");
        input = input.replace("]",")");
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        System.out.println(scriptEngine.eval(input));
    }

}
