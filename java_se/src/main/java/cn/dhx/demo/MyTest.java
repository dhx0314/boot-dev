package cn.dhx.demo;


import cn.dhx.enums.CallDirectEnum;
import cn.dhx.pojo.Stu2;
import cn.dhx.util.DateToolUtil;
import cn.dhx.util.JsonUtil;
import cn.dhx.util.NetByteUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Slf4j
public class MyTest {




    @Test
    public void testList() {


        String s = UUID.randomUUID().toString();
        System.out.println(s);
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes.length);
        byte[] bytes1 = new byte[40];
        System.arraycopy(bytes, 0, bytes1, 0, bytes.length);
        System.out.println(bytes1.length);
        for (byte b : bytes1) {
            System.out.println(b);
            char s2 = (char) b;
            System.out.println(s2);


        }

        System.out.println("-------------");

    }


}





