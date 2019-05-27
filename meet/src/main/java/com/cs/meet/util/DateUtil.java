package com.cs.meet.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String Convertdatetoymd(Date date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return  df.format(df.parse(String.valueOf(date)));

    }
    public static String Convertdatetoymdhm(Date date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return  df.format(df.parse(String.valueOf(date)));

    }
    public static Date ConvertTimeStamptodate(Timestamp timestamp){
        Date date = new Date();
        date=timestamp;
        return date;
    }

    public static Date ConvertStringtoDateyhdhms(String time){
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(time);
            System.out.println(date.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    public static Date ConvertStringtoDateyhd(String time){
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(time);
            System.out.println(date.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Timestamp ConvertDatetoTimestamp(Date date)
    {
        Timestamp ts = new Timestamp(date.getTime());
        return ts;

    }
}
