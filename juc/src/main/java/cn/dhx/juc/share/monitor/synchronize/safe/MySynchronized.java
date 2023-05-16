package cn.dhx.juc.share.monitor.synchronize.safe;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author daihongxin
 * @create 2023/5/10 20:16
 */
@Slf4j
public class MySynchronized {


    // 加锁过程不能被打断
    @Test
    public void interrupt() throws InterruptedException {
        Object lock = new Object();
        Thread thread = new Thread(() -> {
            log.info("start");
            try {
                synchronized (lock) {

                }
            } catch (Exception e) {
                log.info("lockInterruptibly");
                e.printStackTrace();
                return;
            }
            log.info("获得锁");

        });
        synchronized (lock) {
            log.info("获得了锁");
            thread.start();
            TimeUnit.SECONDS.sleep(1);
            thread.interrupt();
            log.debug("执行打断");

        }

        TimeUnit.SECONDS.sleep(10);

    }

}

class TestDemo {
    public synchronized void test() {

    }

    //    等价于
    public void test1() {
        synchronized (this) {

        }
    }
}


class TestDemo2 {
    public static synchronized void test() {

    }

    //    等价于
    public void test1() {
        synchronized (TestDemo2.class) {

        }
    }
}