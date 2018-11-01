package com.learn.text;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/05/28 下午8:39
 */
public class DelZero {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(2.30).setScale(1, BigDecimal.ROUND_DOWN);
        BigDecimal b = new BigDecimal(2.02).setScale(1, BigDecimal.ROUND_DOWN);;
        BigDecimal c =new BigDecimal(2.0).setScale(1, BigDecimal.ROUND_DOWN);
        a.stripTrailingZeros();
        b.stripTrailingZeros();
        c.longValue();
        System.out.println(rvZeroAndDot(a.toString()));
        System.out.println(rvZeroAndDot(b.toString()));
        System.out.println(rvZeroAndDot(c.toString()));

    }



    public static String rvZeroAndDot(String s){
        if (s.isEmpty()) {
            return null;
        }
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }
}
