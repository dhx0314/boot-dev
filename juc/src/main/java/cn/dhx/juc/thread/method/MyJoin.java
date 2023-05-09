package cn.dhx.juc.thread.method;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;


@Slf4j
public class MyJoin {

    static int r=0;

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        log.info("start");
        Thread thread = new Thread(() -> {
            log.info("thread start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r = 10;
            log.info("thread end");
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("print {}",r);
    }
}
