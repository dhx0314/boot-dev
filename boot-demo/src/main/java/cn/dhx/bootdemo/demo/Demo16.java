package cn.dhx.bootdemo.demo;


import java.time.Instant;
import java.util.Date;

public class Demo16 {

    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);//2021-12-26T07:11:24.064Z

        Date from = Date.from(now);
        System.out.println(from);//Sun Dec 26 15:11:24 CST 2021

        Date date = new Date();
        System.out.println(date);//Sun Dec 26 15:11:24 CST 2021
        Instant instant = date.toInstant();
        System.out.println(instant);//2021-12-26T07:11:24.134Z
    }
}
