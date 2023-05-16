package cn.dhx.juc.share.monitor.mode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author daihongxin
 * @create 2023/5/16 22:36
 * 固定顺序执行 先2后1
 */
@Slf4j
public class FixedOrder {

    static Object lock = new Object();
    //线程2是否执行
    static boolean runEd2 = false;

    @Test
    public void waitAndNotify() throws InterruptedException {
        new Thread(() -> {
            synchronized (lock) {
                while (!runEd2) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("t1");
            }
        }, "t1").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            synchronized (lock) {
                log.info("t2");
                runEd2 = true;
                lock.notify();
            }
        }, "t2").start();

        TimeUnit.SECONDS.sleep(10);
    }


    @Test
    public void parkAndUnpark() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            log.info("t1");
        }, "t1");
        t1.start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            log.info("t2");
            LockSupport.unpark(t1);
        }, "t2").start();

        TimeUnit.SECONDS.sleep(10);
    }
}
