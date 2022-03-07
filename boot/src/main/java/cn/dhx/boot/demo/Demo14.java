package cn.dhx.boot.demo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo14 {

    public static void main(String[] args) {

        Date date = new Date(); //获取当前系统时间
        System.out.println(date);   //Sun Dec 26 14:35:17 CST 2021
        Date date1 = new Date(9234567); //通过指定毫秒数 获得时间
        System.out.println(date1);  //Thu Jan 01 10:33:54 CST 1970




        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format); //2021-12-26 14:35:17


        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E").format(date));//2021-12-26 14:37:01 星期日


        String dateStr="2021-12-26 14:37:01";
        try {
            Date parse = simpleDateFormat.parse(dateStr);
            System.out.println(parse);//Sun Dec 26 14:37:01 CST 2021
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
