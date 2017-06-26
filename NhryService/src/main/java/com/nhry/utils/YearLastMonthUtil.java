package com.nhry.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by gongjk on 2016/7/12.
 */
public class YearLastMonthUtil {

    public static void main(String[] args){
        System.out.println(getThisMonthFirstDay());
        System.out.println(getThisMonthLastDay());
        System.out.println(getYearLastMonth());
        System.out.println(getLastMonthFirstDay());
        System.out.println(getLastMonthLastDay());
        System.out.println(getLastDate(new Date()));
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate1 = null;
        try {
            myDate1 = dateFormat1.parse("2009-06-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(getYearMonth(myDate1));
    }
    //获取date所在的年月 例如date是2016-07-26 返回201607
    public static String getYearMonth(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(date);
    }
    //获取本月所在的年月 例如今天是2016-07-26 返回201607
    public static String getYearThisMonth(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(date);
    }


    public static String getYearLastMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        return sdf.format(getLastDate(date));
    }

    //获取这个月 的第一天
    public static Date getThisMonthFirstDay(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH,0);
        c.set(Calendar.DAY_OF_MONTH,1);
        return  c.getTime();
    }
    //获取这个月 的最后一天
    public static Date getThisMonthLastDay(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        return  c.getTime();
    }


    //获取上个月 的第一天
    public static Date getLastMonthFirstDay(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH,1);
        return  c.getTime();
    }
    //获取上个月 的最后一天
    public static Date getLastMonthLastDay(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.DATE, -1);
        return  c.getTime();
    }
    //获取上个月的 今天
    private static Date getLastDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }
}
