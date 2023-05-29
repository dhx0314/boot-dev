package cn.dhx.demo;

import cn.dhx.util.JsonUtil;
import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/16 11:14
 */
@Slf4j
public class MyTest2 {

    public static void main(String[] args) {


        String uri = "127.0.0.1:8087";
        String receiverPath = "aaa";
        String urlFormat = "http://%s/%s";
        String url = String.format(urlFormat, uri, receiverPath);
        System.out.println(url);
    }
}
