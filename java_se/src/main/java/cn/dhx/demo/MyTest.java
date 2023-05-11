package cn.dhx.demo;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author daihongxin
 * @create 2023/4/10 10:43
 */
public class MyTest {

    @Test
    public void fun1() {

//        String[] record = {"call_id", "call_direct", "agent_id"};
//
//        for (int i = 0; i < record.length - 1; i++) {
//            System.out.println(record[i]);
//        }
//        int i=0;
//        String s = String.valueOf(++i);
//        String s = String.valueOf(i++);
//        System.out.println(s);

//        System.currentTimeMillis()
//        Instant now = Instant.now();
//        System.out.println(now.);

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            s.append("%s").append("|");
        }

        System.out.println(s);
    }

    @Test
    public void fun21() {

        String p = "^1\\\\d{1,8}$";
        String deviceId="1003";
        boolean matches = deviceId.matches(p);
        System.out.println(matches);

//        String endPath = "2023/03/30/";
//        String endPathStr = endPath.substring(0, endPath.lastIndexOf("/"));
//        System.out.println(endPathStr);


    }
}
