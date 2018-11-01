package com.learn.设计模式.模板方法模式;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 5:35 PM
 */
public abstract class AbstractCaluclator {

    /** 主方法，实现对本类其他方法的调用 */
    public final int calculate(String exp,String opt){
        int array[] = splist(exp,opt);
        return calculate(array[0],array[1]);
    }

    abstract public int calculate(int num1,int num2);

    private int[] splist(String exp,String opt){
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;

    }


}
