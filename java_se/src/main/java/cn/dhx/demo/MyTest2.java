package cn.dhx.demo;

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


        int length=5;
        for (int i = 0; i < 20; i++) {
            System.out.println(i%length);
        }

    }
}
