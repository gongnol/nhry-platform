package com.nhry.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by gongjk on 2016/7/12.
 */
public class DateUtil {

  public static void main(String[] args){
//        System.out.println(getYestoday(new Date()));
//        System.out.println(getTomorrow(new Date()));
//
//        System.out.println(getDayAfterTomorrow(new Date()));

          System.out.println(getYmd(new Date()));
    }

    public static boolean dateBefore(Date d1,Date d2){
        if(d1!=null && d2!=null){
           // System.out.println("年月日格式前"+d1+"----"+d2);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = null;
            Date date2 = null;
            try {
                date1  = format.parse(format.format(d1));
                date2 = format.parse(format.format(d2));
               // System.out.println("年月日格式后"+date1+"----"+date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date1.before(date2);
        }
        return d1.before(d2);
    }
    public static boolean dateAfter(Date d1,Date d2){
        if(d1!=null && d2!=null){
            //System.out.println("年月日格式前"+d1+"----"+d2);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = null;
            Date date2 = null;
            try {
                date1  = format.parse(format.format(d1));
                date2 = format.parse(format.format(d2));
               // System.out.println("年月日格式后"+date1+"----"+date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date1.after(date2);
        }
        return d1.after(d2);
    }
    //获取date 日期的年月日
    public static Date getYmd(Date today) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR,today.getYear());
        calendar.set(Calendar.MONTH,today.getYear());
        calendar.set(Calendar.DAY_OF_YEAR,today.getDay());
        calendar.set( Calendar.HOUR_OF_DAY, 0);
        calendar.set( Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date day = calendar.getTime();
        return day;
    }

    //获取date 日期的明天
    public static Date getYestoday(Date today) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(today);
        calendar.add(calendar.DATE,-1);//把日期往后增加1天.整数往后推 这个时间就是日期往后推一天的结果
        Date firstDay = calendar.getTime();
        return firstDay;
    }


    //获取date 日期的明天
    public static Date getTomorrow(Date today) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(today);
        calendar.add(calendar.DATE,1);//把日期往后增加1天.整数往后推 这个时间就是日期往后推一天的结果
        Date firstDay = calendar.getTime();
        return firstDay;
    }
    //获取date 日期的后天
    public static Date getDayAfterTomorrow(Date today){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(today);
        calendar.add(calendar.DATE,2);//把日期往后增加2天.整数往后推 这个时间就是日期往后推两天的结果
        Date secondDay = calendar.getTime();
        return secondDay;
    }

    //获取date 日期的后 i 天
    public static Date getDay(Date today,int i){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(today);
        calendar.add(calendar.DATE,i);
        Date secondDay = calendar.getTime();
        return secondDay;
    }
    public static  boolean sameDateOrYestaday(Date day1 , Date day2){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if(format.format(day1).equals(format.format(day2))){
            return true;
        }else if(format.format(day2).equals(format.format(getYestoday(day1)))){
            return true;
        }else {
            return false;
        }
    }


}
