package cn.dhx.boot.demo;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author daihongxin
 * @create 2023/8/23 16:59
 */
@Slf4j
public class Demo2 {


    @Test
    public void fun2() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        String remove = concurrentHashMap.remove("1123");
        System.out.println(remove);


        String file = "/home/spdb/recorder-config-service/logs/2023-10-19/config-info.20231019-0.log";
        String substring = file.substring(file.lastIndexOf("/")+1);
        System.out.println(substring);
        boolean contains = substring.contains(".log");
        System.out.println(contains);
    }

    @Test
    public void fun1() {


        try {
            byte[] b_gbk = "中文".getBytes("GBK");
//            byte[] b_utf8 = "????".getBytes("UTF-8");
            System.out.println(Arrays.toString(b_gbk));

            String s = new String(b_gbk, "UTF-8");
            System.out.println(s);
            System.out.println(Arrays.toString(s.getBytes()));
//            System.out.println(s.);
            byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
            System.out.println(new String(bytes,"GBK"));
//            System.out.println(Arrays.toString(b_utf8));
//            byte[] b_iso88591 = "中文".getBytes("ISO8859-1");
//            System.out.println(Arrays.toString(b_iso88591));
//            String s_gbk = new String(b_gbk,"GBK");
//            String s_utf8 = new String(b_utf8,"UTF-8");
//
//            String s_iso88591 = new String(b_iso88591,"ISO8859-1");
//
//            System.out.println("---"+new String(b_iso88591,"UTF-8"));
//
//            System.out.println("GBK 编码的字符串："+ s_gbk);
//            System.out.println("UTF-8 编码的字符串："+ s_utf8);
//            System.out.println("ISO8859-1编码的字符串："+ s_iso88591);
//
//
//            String str = "中文";
//            String s = new String(str.getBytes("ISO-8859-1"), "UTF-8");
//            System.out.println(s);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
