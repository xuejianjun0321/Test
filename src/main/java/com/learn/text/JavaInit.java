package com.learn.text;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/10/15 11:26
 */
public class JavaInit {

    public static int count1;
    public static int count2 = 1;
    private static JavaInit singleTon = new JavaInit();

    private JavaInit() {
        count1++;
        count2++;
    }

    public static JavaInit getInstance() {
        return singleTon;
    }
}
 class Demo {
    public static void main(String[] args) {
        JavaInit singleTon = JavaInit.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }

}
