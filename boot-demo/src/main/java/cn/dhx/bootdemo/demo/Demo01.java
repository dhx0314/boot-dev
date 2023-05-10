package cn.dhx.bootdemo.demo;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo01 {


    @Test
    public void long2String() {

        String num = "^6\\d{0,7}";

        String deviceId = "66623";
//        String deviceId = "66623";
        if (num.contains("^") || num.contains("$")) {
            boolean matches = deviceId.matches(num);
            System.out.println(matches);
//
        }
    }


    @Test
    public void fun2wuuu() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("aaa", "2");
        concurrentHashMap.put("bbb", "2");
        System.out.println(concurrentHashMap.size());

        ConcurrentHashMap.KeySetView<String, String> strings = concurrentHashMap.keySet();
        for (String string : strings) {
            System.out.println(string);
        }

    }


    @Test
    public void fun2() {
        AtomicInteger currentPoolSize = new AtomicInteger(0);
        currentPoolSize.incrementAndGet();
        System.out.println(currentPoolSize.get());
        System.out.println(currentPoolSize.get());
        currentPoolSize.getAndIncrement();
        System.out.println(currentPoolSize.get());
    }


    @Test
    public void fun3() {
        byte[] voiceBytes = new byte[4];
        voiceBytes[0] = 1;
        voiceBytes[1] = 2;
        voiceBytes[2] = 3;

        byte[] voiceBytes2 = new byte[voiceBytes.length];
        System.arraycopy(voiceBytes, 0, voiceBytes2, 0, voiceBytes2.length);
        voiceBytes[1] = 11;

        System.out.println(Arrays.toString(voiceBytes));
        System.out.println(Arrays.toString(voiceBytes2));

//        System.out.println(this.getClass().get);
    }
}
