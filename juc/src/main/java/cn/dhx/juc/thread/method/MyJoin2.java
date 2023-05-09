package cn.dhx.juc.thread.method;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


@Slf4j
public class MyJoin2 {

    static int r = 0;
    static int r1 = 0;

    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test() throws Exception {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r = 10;
        });
        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1 = 20;
        });

        thread.start();
        thread2.start();
        long l = System.currentTimeMillis();
        log.info("start");
        thread.join();
        log.info("thread end");
        thread2.join();
        log.info("thread2 end");
        long l1 = System.currentTimeMillis();

        log.info("print r {} r1 {} cost {}", r, r1, l1 - l);
    }
}
