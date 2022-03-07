package cn.dhx.boot.demo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Demo17 {

    public static void main(String[] args) {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);



        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZoneId zone1 = ZoneId.systemDefault();
        Instant instant1 = localDateTime1.atZone(zone1).toInstant();
        Date date1 = Date.from(instant1);
    }
}
