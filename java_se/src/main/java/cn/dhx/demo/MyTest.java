package cn.dhx.demo;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author daihongxin
 * @create 2023/4/10 10:43
 */
public class MyTest {

    @Test
    public void fun1() {

        long l=-1000;
        long l1 = l % 500;
        System.out.println(l1);
        System.out.println(l%500==0);
    }

    @Test
    public void fun21() {

        String s="qwer";
        byte[] bytes = new byte[6];
        bytes = s.getBytes(StandardCharsets.UTF_8);
        String s1 = Arrays.toString(bytes);
        System.out.println(s1);
        System.out.println(bytes.length);
        String s2 = new String(bytes);
        System.out.println(s2);
    }
}
