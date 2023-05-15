package cn.dhx.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/4/10 10:43
 */
public class MyTest {

    @Test
    public void fun1() throws InterruptedException {
        new Thread(()->{
            b b = new b();
            while (true) {
                b.to2();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        TimeUnit.SECONDS.sleep(2);
        new Thread(()->{
            A.set();
            A.to3();
        }).start();

        TimeUnit.SECONDS.sleep(10);
    }
}

@Slf4j
class A{
    public static String filePathTemp="ok";

    public static void set() {
        filePathTemp="not ok";
    }

    public static void to3() {
        log.info("to3 {}", filePathTemp);
    }
}


@Slf4j
class b{
    private String temp = A.filePathTemp;

    public void to() {
        log.info("temp {}", temp);
    }

    public void to2() {
        log.info("temp to2 {}", A.filePathTemp);
    }
}

