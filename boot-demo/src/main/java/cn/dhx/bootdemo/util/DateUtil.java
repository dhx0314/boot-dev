package cn.dhx.bootdemo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {


    public static String dateToDateString(String now) throws ParseException {

//        String now = "Wed Feb 27 12:55:55 CST 2013";
//        String now = "Wed Feb 27 12:55:55 CST 2013";
        DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CST' yyyy", Locale.US);
        //把字符串转换成CST日期类型
        Date date = df.parse(now);
        System.out.println(date);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //把CST格式转换成普通日期格式
        String format = sdf.format(date);
        System.out.println(format);
        return format;

    }

    public static Date dateToDate(String now) throws ParseException {


        DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CST' yyyy", Locale.US);
        //把字符串转换成CST日期类型
        Date date = df.parse(now);
        return date;
//        System.out.println(date);
//        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //把CST格式转换成普通日期格式
//        String format = sdf.format(date);
//        System.out.println(format);
//        return format;

    }

    public static Date stringDate(String now) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(now);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
