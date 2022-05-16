package com.手撕算法.牛客网;


import java.util.Scanner;

/**
 * 描述
 * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 *
 * 具体规则如下:
 * 1.在英语读法中三位数字看成一整体，后面再加一个计数单位。从最右边往左数，三位一单位，例如12,345 等
 * 2.每三位数后记得带上计数单位 分别是thousand, million, billion.
 * 3.公式：百万以下千以上的数 X thousand X, 10亿以下百万以上的数：X million X thousand X, 10 亿以上的数：X billion X million X thousand X. 每个X分别代表三位数或两位数或一位数。
 * 4.在英式英语中百位数和十位数之间要加and，美式英语中则会省略，我们这个题目采用加上and，百分位为零的话，这道题目我们省略and
 *
 * 下面再看几个数字例句：
 * 22: twenty two
 * 100:  one hundred
 * 145:  one hundred and forty five
 * 1,234:  one thousand two hundred and thirty four
 * 8,088:  eight thousand (and) eighty eight (注:这个and可加可不加，这个题目我们选择不加)
 * 486,669:  four hundred and eighty six thousand six hundred and sixty nine
 * 1,652,510:  one million six hundred and fifty two thousand five hundred and ten
 *
 * 说明：
 * 数字为正整数，不考虑小数，转化结果为英文小写；
 * 保证输入的数据合法
 * 关键字提示：and，billion，million，thousand，hundred。
 */
public class 学英语 {

    /**
     * 小于20的直接读数，如果个位和十位是0，则不需要读数（正百的100，例：one hundred）；如果有百位读取百位，如果个位和十位是0，则不需要加and，否则需要加and，加hubdred，加百位 2、大于20的，依次添加个位，十位，百位；添加百位的时候，先加and，加hundred，加百位
     */
    private static String[] ones = new String[]{
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "forteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};

    private static String[] twieties = new String[]{"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str.length() <= 9) {
                System.out.println(getEn(Integer.parseInt(str)));
            } else {
                System.out.println("error");
            }
        }
        sc.close();
    }

    private static String getEn(int num) {
        String stren = "error";
        if (num <= 20) {
            stren = ones[num];
        } else if (num < 100) {
            int remainder = num % 10;
            if (remainder == 0) {
                stren = twieties[num / 10];
            } else {
                stren = twieties[num / 10] + " " + ones[remainder];
            }
        } else if (num < 1000) {
            int remainder = num % 100;
            if (remainder == 0) {
                stren = ones[num / 100] + " hundred";
            } else {
                stren = ones[num / 100] + " hundred and " + getEn(remainder);
            }
        } else if (num < 1000000) {
            int remainder = num % 1000;
            if (remainder == 0) {
                stren = getEn(num / 1000) + " thousand";
            } else {
                stren = getEn(num / 1000) + " thousand " + getEn(remainder);
            }
        } else if (num < 1000000000) {
            int remainder = num % 1000000;
            if (remainder == 0) {
                stren = getEn(num / 1000000) + " million";
            } else {
                stren = getEn(num / 1000000) + " million " + getEn(remainder);
            }
        }
        return stren;
    }
}
