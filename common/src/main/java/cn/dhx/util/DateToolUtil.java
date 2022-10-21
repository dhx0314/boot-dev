package cn.dhx.util;

import cn.hutool.core.date.DateUtil;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Date;

public class DateToolUtil {


    public static WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,1);

    public static LocalDateTime getNowWithMinute() {
        return LocalDateTime.now().withSecond(0).withNano(0);
    }

    public static String localDateTimeToStr(LocalDateTime localDateTime) {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(ofPattern);
    }

    public static String localDateToStr(LocalDate localDate) {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDate.format(ofPattern);
    }

    public static LocalDateTime strToLocalDateTime(String strTime) {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(strTime, ofPattern);
        return dateTime;
    }

    public static LocalDate strDayToLocalDate(String strTime) {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(strTime, ofPattern);
        return localDate;
    }

    public static String localDateTimeToRedisKey(LocalDateTime localDateTime) {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        return localDateTime.format(ofPattern);
    }

    public static Date timeStampToDate(Integer time) {
        return new Date(time * 1000L);
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        LocalDateTime ldt = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        return ldt;
    }

    public static LocalDate dateToLocalDate(Date date) {
        LocalDateTime ldt = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        return ldt.toLocalDate();
    }



    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date localDateToDate(LocalDate localDate) {
        LocalDateTime localDateTime = localDate.atStartOfDay();
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date strToDate(String dateStr) {
        return DateUtil.parse(dateStr, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date strToDateDay(String dateStr) {
        return DateUtil.parse(dateStr, "yyyy-MM-dd");
    }

    public static String dateToStr(Date date) {
        return  DateUtil.formatDateTime(date);
    }

    public static Long strToTimeStamp(String strTime) {
        LocalDateTime localDateTime = strToLocalDateTime(strTime);
        long l = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        return l / 1000;
    }

}
