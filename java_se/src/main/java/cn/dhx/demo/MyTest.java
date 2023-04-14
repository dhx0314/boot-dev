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

//        int i=0;
//        String s = String.valueOf(++i);
//        String s = String.valueOf(i++);
//        System.out.println(s);

//        System.currentTimeMillis()
//        Instant now = Instant.now();
//        System.out.println(now.);
    }

    @Test
    public void fun21() {

        String endPath = "2023/03/30/";
        String endPathStr = endPath.substring(0, endPath.lastIndexOf("/"));
        System.out.println(endPathStr);


    }
}
