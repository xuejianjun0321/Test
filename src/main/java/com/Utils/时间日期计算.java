package com.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/12/06 2:06 PM
 */
public class 时间日期计算 {


    public static void main(String[] args){
//        twoDateCirculation();
        获取过去时间();
        System.out.println(1/10);
    }


    public static void 获取过去时间(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();

        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, - 7);
        Date d = c.getTime();
        String day = format.format(d);
        System.out.println("过去七天："+day);

        //过去一月
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        System.out.println("过去一个月："+mon);

        //过去三个月
        c.setTime(new Date());
        c.add(Calendar.MONTH, -3);
        Date m3 = c.getTime();
        String mon3 = format.format(m3);
        System.out.println("过去三个月："+mon3);

        //过去一年
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        System.out.println(c.getTimeInMillis());
        System.out.println(y.getTime());
        String year = format.format(y);
        System.out.println("过去一年："+year);


    }



    /**
     * 两个日期之间所有日期的遍历
     */
    public static void twoDateCirculation(){

        try {
            Date start = StrToDate("2018-10-01");
            Date end = StrToDate("2018-11-27");

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {

                System.out.println("累计前"+DateToStr(tempStart.getTime()));
//
//                Calendar addDate = (Calendar)tempStart.clone();
//                addDate.add(Calendar.DAY_OF_YEAR, 1);
//                System.out.println("XXX"+DateToStr(addDate.getTime()));

                tempStart.add(Calendar.DAY_OF_YEAR, 1);

                System.out.println("累积后"+DateToStr(tempStart.getTime()));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 字符串转换成日期
     * @param str
     * @return date
     */
    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期转换成字符串
     * @param date
     * @return str
     */
    public static String DateToStr(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String str = format.format(date);
        return str;
    }


    /**
     * 获取两个日期之间的所有日期
     *
     * @param startTime
     *            开始日期
     * @param endTime
     *            结束日期
     * @return
     */
    public static List<String> getDays(String startTime, String endTime) {

        // 返回的日期集合
        List<String> days = new ArrayList<String>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return days;
    }

}
