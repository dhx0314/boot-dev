package cn.dhx.juc.share.monitor.synchronize.safe;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/10 20:16
 */
@Slf4j
public class MySynchronizedLock8 {

    @Test
    public void lock1() throws InterruptedException {
        class Number {
            public synchronized void a(){
                log.info("1");
            }
            public synchronized void b(){
                log.info("2");
            }
        }

        Number number = new Number();
        log.info("start");
        new Thread(() -> {
            number.a();
        }).start();
        new Thread(() -> {
            number.b();
        }).start();

        TimeUnit.SECONDS.sleep(5);
    }

    // 情况1：12
    // 情况2：21


    @Test
    public void lock2() throws InterruptedException {
        class Number {
            public synchronized void a(){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("1");
            }
            public synchronized void b(){
                log.info("2");
            }
        }

        Number number = new Number();
        log.info("start");
        new Thread(() -> {
            number.a();
        }).start();
        new Thread(() -> {
            number.b();
        }).start();

        TimeUnit.SECONDS.sleep(5);
    }

    //  情况1：1s后  12
    //  情况2：2 1s后 1



    @Test
    public void lock3() throws InterruptedException {
        class Number {
            public synchronized void a(){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("1");
            }
            public synchronized void b(){
                log.info("2");
            }
            public void c(){
                log.info("3");
            }
        }

        Number number = new Number();
        log.info("start");
        new Thread(() -> {
            number.a();
        }).start();
        new Thread(() -> {
            number.b();
        }).start();
        new Thread(() -> {
            number.c();
        }).start();

        TimeUnit.SECONDS.sleep(5);

        //  情况1：3  1s后  12
        //  情况2：23 1s后 1
        //  情况3：32 1s后 1
    }

    @Test
    public void lock4() throws InterruptedException {
        class Number {
            public synchronized void a(){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("1");
            }
            public synchronized void b(){
                log.info("2");
            }
        }

        Number number = new Number();
        Number number2 = new Number();
        log.info("start");
        new Thread(() -> {
            number.a();
        }).start();
        new Thread(() -> {
            number2.b();
        }).start();

        TimeUnit.SECONDS.sleep(5);

        // 情况1：2 1s后1
    }

}
