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


        String abc = new String("abc");
        byte[] bytes = abc.getBytes(StandardCharsets.UTF_8);

        byte[] bytes1 = abc.getBytes(StandardCharsets.UTF_8);

        String s = new String(bytes1);
        System.out.println(bytes1.equals(bytes));

        System.out.println(s.equals(abc));


    }


}





