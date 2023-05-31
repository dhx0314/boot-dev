package cn.dhx.demo;

import cn.dhx.util.DateToolUtil;
import cn.dhx.util.JsonUtil;
import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/16 11:14
 */
@Slf4j
public class MyTest2 {

    public static void main(String[] args) {
//        System.out.println("hello world");

        Date date = new Date();
        LocalDate localDate = DateToolUtil.dateToLocalDate(date);
        String s = DateToolUtil.localDateToStrPath(localDate);
        System.out.println(s);

        String s1 = DateToolUtil.dateToStrPath(date);
        System.out.println(s1);
    }
}
