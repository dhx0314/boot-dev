package cn.dhx.bootdemo.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Demo15 {

    public static void main(String[] args) {
        LocalDate now1 = LocalDate.now();
        System.out.println(now1);//2021-12-26
        LocalTime now2 = LocalTime.now();
        System.out.println(now2);//14:50:24.960



        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);//2021-12-26T14:50:24.960

        LocalDateTime localDateTime = LocalDateTime.now().withNano(0);
        System.out.println(localDateTime);//2021-12-26T14:50:24

        LocalDate localDate = now.toLocalDate();
        System.out.println(localDate);//2021-12-26

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(now);
        System.out.println(format);//2021-12-26 14:57:53

        String dateStr="2021-12-26 14:57:53";
        LocalDateTime parse = LocalDateTime.parse(dateStr, dateTimeFormatter);
        System.out.println(parse);//2021-12-26T14:57:53
    }
}
