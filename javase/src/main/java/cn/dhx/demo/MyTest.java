package cn.dhx.demo;


import cn.dhx.util.DateToolUtil;
import cn.dhx.util.NetByteUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTest {


    @Test
    public void fun237ss() {
        String s=null;
        if (s != null) {
            System.out.println("a");
        }
    }

    @Test
    public void funaaa() {

//        LocalDate now = LocalDate.now();
//        int monthValue = now.getMonthValue();
//        System.out.println(monthValue);
//        LocalDate currDate = LocalDate.now();

        String s="2022-02-09";


        LocalDate currDate   = DateToolUtil.strDayToLocalDate(s);

        // 当月第一天
        LocalDate firstDayOfMonth = currDate.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth);

        // 当月最后一天
        LocalDate lastDayOfMonth = currDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfMonth);
    }

    @Test
    public void funwaiefiaweg() {


        LocalDate now = LocalDate.now();
        Date date = DateToolUtil.localDateToDate(now);
        System.out.println(date);

        String s="2022-02-09";


        LocalDate localDate   = DateToolUtil.strDayToLocalDate(s);
        int value = localDate.getDayOfWeek().getValue();
        LocalDate localDate1 = localDate.minusDays(value - 1);
        System.out.println(localDate1);
        LocalDate localDate2 = localDate1.plusDays(6);
        System.out.println(localDate2);
    }

    @Test
    public void fun22aaa() {

        //获取当前时间
//        LocalDateTime currentDate = LocalDateTime.now();

        String s="2022-08-07";

        Date date = DateToolUtil.strToDate(s);
        System.out.println(date);
        String s1 = DateToolUtil.dateToStr(date);
        System.out.println(s1);
        LocalDate currentDate = DateToolUtil.strDayToLocalDate(s);
        //获取年份
        int year = currentDate.getYear();
        System.out.println("获取当前年份:" + year);
        //获取月份
        int month = currentDate.getMonthValue();
        System.out.println("获取当前月份:" + month);
        //获取当前周
        int week = currentDate.getDayOfWeek().getValue();
        System.out.println("获取当前周:" + week);
        //获取当前时间第X周
        /*
        public static WeekFields of​(DayOfWeek firstDayOfWeek, int minimalDaysInFirstWeek)
        从第一天和最小日期获得WeekFields的实例。
        第一天的每周定义ISO DayOfWeek ，即一周中的第一天。 第一周的最小天数定义一个月或一年中必须存在的天数，从第一天开始，在将一周计算为第一周之前。 值1将计算作为第一周的一部分的月或年的第一天，而值7将要求整个七天在新的月或年中。

        WeekFields实例是单例; 对于firstDayOfWeek和minimalDaysInFirstWeek的每个唯一组合，将返回相同的实例。

        参数
        firstDayOfWeek - 一周的第一天，不是null
        minimalDaysInFirstWeek - 第一周的最小天数，从1到7
         */
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY,1);
        int weeks = currentDate.get(weekFields.weekOfYear());
        System.out.println("获取当前时间第" + weeks + "周");

    }


    public static LocalDate strDayToLocalDateTime(String strTime) {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(strTime, ofPattern);
        return dateTime;
    }


    @Test
    public void fun123432() {
        String s="2022-08-02";
        LocalDate localDateTime = strDayToLocalDateTime(s);
        System.out.println(localDateTime);
    }

    @Test
    public void fun1232() {

//        BigDecimal b = new BigDecimal(2).multiply(new BigDecimal(10000));
        BigDecimal b = new BigDecimal(2);
        b = b.divide(new BigDecimal(7), 4, BigDecimal.ROUND_HALF_UP);
        System.out.println(b);

        //输出是0.71
        BigDecimal b2 = new BigDecimal(5);
        b2 = b2.divide(new BigDecimal(7), 4, BigDecimal.ROUND_HALF_UP);
        System.out.println(b2);



        //2857
        //7142

    }

    @Test
    public void fuwaef() {
        HashSet<String> strings = new HashSet<>();
        strings.add("2022-08-02 10:45:00");
        strings.add("2022-08-02 11:00:00");
        strings.add("2022-08-02 18:00:00");

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s).append(",");
        }
        System.out.println(stringBuilder);
        String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
        System.out.println(substring);
    }

    @Test
    public void funa2a() {
        Stu stu = new Stu();
        System.out.println(stu);
    }



    @Test
    public void fun132223() {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());

        Timestamp timestamp = new Timestamp(1644803779);
        System.out.println(timestamp);
        int time=1644803779;
        Date date = new Date(time * 1000L);
        System.out.println(date);
    }


    @Test
    public void fun0706() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            LocalDateTime now = LocalDateTime.now();
            System.out.println(now);
            Thread.sleep(20);
        }


    }


    @Test
    public void fun10628() {
        byte[] udpByte = new byte[2];
        udpByte[1] = 0x60;
        int payloadType = udpByte[1] & 0x7F;
        System.out.println(payloadType);
    }


    @Test
    public void fun1c0625() {
//        String s = new String("18270779730");
//        byte[] sessionID = new byte[48];
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            sessionID[i]= (byte) c;
//        }
//        for (byte b : sessionID) {
//            System.out.println(b);
//        }

        byte[] bytes = new byte[3];
        bytes[0]=(byte) '1';
        System.out.println(bytes[0]);
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
    }


    @Test
    public void fun1b0625() {
        byte[] bytes = NetByteUtil.intToByteLittle(188);
        int i = NetByteUtil.bytesToIntLittle(bytes);
        System.out.println(i);

        Stu stu = new Stu();
        byte[] wavDirect = stu.getWavDirect();
        System.out.println(wavDirect.length);
    }


    @Test
    public void funa0625() {
        String s="68731";
        byte[] wavDirectCustom = {1, 0, 0, 0};
        String s1 = new String(wavDirectCustom);
        System.out.println(s1);
        byte[] bytes1 = NetByteUtil.intToBytes(1);
//        String s1 = bytes1.toString();
        System.out.println(bytes1.length);
        int i = NetByteUtil.bytesToInt(bytes1);
        System.out.println(i);
        byte[] bytes = Stu.bytes;
        System.out.println(bytes.length);
//        System.out.println(s1);
//        String s1 = new String(wavDirectCustom);
//        System.out.println(s1);
//        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
//        System.out.println(bytes.length);
    }


    @Test
    public void fun1awe() {
//        byte[] bytes={'V','C'};
        byte[] bytes={86,67};
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        String s = new String(bytes);
        System.out.println(s);
    }





    @Test
    public void fun1awea() {
        byte[] bytes = new byte[4];
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }

        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.get();
        System.out.println(i);
    }


    @Test
    public void arra() {
//        int[] arr1=new int[4];
//        int[] arr2=new int[1];
//
//        if (arr1.length < arr2.length * 2) {
//            System.out.println("aa");
//        }
        Integer i1 = 33;
        Integer i2 = 33;
        System.out.println(i1 == i2);

    }

    @Test
    public void fun1aa() {
        System.out.println(digui(100));
    }


    @Test
    public void funa2332() {
        byte[] bytes = new byte[4];
        bytes[0]= (byte) 0x00;
        bytes[1]= (byte) 0x00;
        bytes[2]= (byte) 0x00;
        bytes[3]= (byte) 0xb9;
        int i = NetByteUtil.bytesToInt(bytes);
        System.out.println(i);

    }


    public int digui(int i) {
        if (i == 1) {
            return 1;
        }
        return i+digui(i-1);
    }


    @Test
    public void fun1a2() {
        System.out.println(digui2(1));
    }

    public int digui2(int i) {
        if (i == 100) {
            return 100;
        }
        return i+digui2(i+1);
    }

    @Test
    public void fun1() {
        String number="901827077973011111";
//        String number="18270779730";
        String regex="\\d{11,}";
        boolean matches = number.matches(regex);
        System.out.println(matches);
        String firstNum = String.valueOf(number.charAt(0));
        String secondNum = String.valueOf(number.charAt(1));
        System.out.println(firstNum);
        System.out.println(secondNum);
    }


    @Test
    public void fu1() {
//        String json="{\"method\":\"makeCall\",\"object\":\"cti\",\"params\":[{\"dest\":\"9018270779730\",\"deviceId\":\"6873\",\"origin\":\"6873\"}]}";

//        String json = "{\"method\":\"makeCall\",\"object\":\"cti\",\"params\":[{\"userData\":{\"map\":{\"uui\":\"90007238test\"}},\"dest\":\"9018270779730\",\"deviceId\":null,\"origin\":null}]}";

//        String json="{\"method\":\"makeCall\",\"object\":\"cti\",\"params\":[{\"userData\":{\"map\":{\"uui\":\"90007238test\"}},\"dest\":\"9018270779730\",\"deviceId\":\"\",\"origin\":\"\"}]}";
        String json = "{\"method\":\"makeCall\",\"object\":\"cti\",\"params\":[{\"userData\":{\"map\":{\"uui\":\"90007238test\"}},\"dest\":\"9018270779730\",\"deviceId\":\"\",\"origin\":null}]}";


        JsonParser parser = new JsonParser();
        JsonObject asJsonObject = parser.parse(json).getAsJsonObject();
        JsonElement method1 = asJsonObject.get("method");
        if (null != method1 && !method1.isJsonNull()) {
            String method = method1.getAsString();
            if ("makeCall".equals(method)) {
                JsonArray jsonArray = asJsonObject.get("params").getAsJsonArray();
                if (null != jsonArray && !jsonArray.isJsonNull()) {
                    if (jsonArray.size() > 0) {
                        JsonObject asJsonObject1 = jsonArray.get(0).getAsJsonObject();
                        JsonElement deviceId = asJsonObject1.get("deviceId");
//                        deviceId":null  -> deviceId.isJsonNull()
//                        deviceId":"" -> cti 会报错提示无效分机号
                        if (null == deviceId || deviceId.isJsonNull()) {
                            System.out.println("fail deviceId ");
                        }
                        JsonElement origin = asJsonObject1.get("origin");
                        if (null == origin || origin.isJsonNull()) {
                            System.out.println("fail origin");
                        }

                    }
                }
            }
        }
        System.out.println("----- ok");


    }


    @Test
    public void fu12() {
        String s = null;
        System.out.println("aa".equals(s));
    }
}





