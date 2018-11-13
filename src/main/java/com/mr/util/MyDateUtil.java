package com.mr.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by JangSinyu on 2018/11/12.
 */
public class MyDateUtil {

    /**
     *获取时间String类型
     */
    public static String getDateStringType(Date date, int n){
        Calendar instance = Calendar.getInstance();
        String format = new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime());
        return format;
    }

    /**
     * 获取时间date类型
     * @return
     */
    public static Date getMyDateType(Date date , int n){
        Calendar instance = getCalendar(date, n);
        return instance.getTime();
    }


    /**
     *  n 大于0  是几天后 ，小于0是
     * @param date
     * @param n
     * @return
     */
    public static Calendar getCalendar(Date date , int n){
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int day = instance.get(Calendar.DATE);
        if(n >= 0){
            instance.set(Calendar.DATE,day + n);
        }else{
            instance.set(Calendar.DATE,day - Math.abs(n));
        }
        return instance;
    }



}
