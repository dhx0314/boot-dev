package cn.dhx.juc.share.monitor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/10 20:34
 */
@Slf4j
public class MySynchronizedLock8_2 {

    @Test
    public void lock5() throws InterruptedException {
        Number1 number1 = new Number1();
        log.info("start");
        new Thread(() -> {
            number1.a();
        }).start();
        new Thread(() -> {
            number1.b();
        }).start();

        TimeUnit.SECONDS.sleep(5);
    }
    //  情况1：2 1s后 1


    @Test
    public void lock6() throws InterruptedException {
        Number2 number2 = new Number2();
        log.info("start");
        new Thread(() -> {
            number2.a();
        }).start();
        new Thread(() -> {
            number2.b();
        }).start();

        TimeUnit.SECONDS.sleep(5);
    }
    //  情况1：2 1s后 1
    //  情况2：1s后 12


    @Test
    public void lock7() throws InterruptedException {
        Number1 number1_0 = new Number1();
        Number1 number1_1 = new Number1();
        log.info("start");
        new Thread(() -> {
            number1_0.a();
        }).start();
        new Thread(() -> {
            number1_1.b();
        }).start();

        TimeUnit.SECONDS.sleep(5);
    }
    //  情况1：2 1s后 1


    @Test
    public void lock8() throws InterruptedException {
        Number2 number2_0_ = new Number2();
        Number2 number2_1_ = new Number2();
        log.info("start");
        new Thread(() -> {
            number2_0_.a();
        }).start();
        new Thread(() -> {
            number2_1_.b();
        }).start();

        TimeUnit.SECONDS.sleep(5);
    }
    //  情况1：2 1s后 1
    //  情况2：1s后 12

}

@Slf4j
class Number1 {
    public static synchronized void a() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("1");
    }

    public synchronized void b() {
        log.info("2");
    }
}

@Slf4j
class Number2 {
    public static synchronized void a() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("1");
    }

    public static synchronized void b() {
        log.info("2");
    }
}