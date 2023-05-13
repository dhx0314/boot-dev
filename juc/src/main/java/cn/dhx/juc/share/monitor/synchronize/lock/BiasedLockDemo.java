package cn.dhx.juc.share.monitor.synchronize.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/12 23:46
 * 偏向锁
 */
@Slf4j
public class BiasedLockDemo {


    // 关闭偏向锁延迟
    //-XX:BiasedLockingStartupDelay=0
    public static void main(String[] args) throws InterruptedException {
        Dog d = new Dog();
        ClassLayout classLayout = ClassLayout.parseInstance(d);
//        log.info("classLayout {}",classLayout.toPrintable(d));

        Thread thread = new Thread(() -> {
            log.info("start {}", classLayout.toPrintable());
            synchronized (d) {
                log.info("in {}", classLayout.toPrintable());
            }
            log.info("end {}", classLayout.toPrintable());
        });
        thread.start();
        thread.join();

    }
    //处于偏向锁的对象解锁后，线程 id 仍存储于对象头中


    //-XX:BiasedLockingStartupDelay=0
    @Test
    public void revokeByHashCode() throws InterruptedException {
        Dog d = new Dog();
        ClassLayout classLayout = ClassLayout.parseInstance(d);
        Thread thread = new Thread(() -> {
            log.info("start {}", classLayout.toPrintable());
            synchronized (d) {
                log.info("in {}", classLayout.toPrintable());
                d.hashCode();
                log.info("in hashcode{}", classLayout.toPrintable());
            }

            log.info("end {}", classLayout.toPrintable());
        });
        thread.start();
        thread.join();
    }

    @Test
    public void revokeByOtherThread() throws InterruptedException {
        Dog d = new Dog();
        Thread thread1 = new Thread(() -> {
            synchronized (d) {
                log.info("thread1 {}", ClassLayout.parseInstance(d).toPrintable());
            }
            synchronized (BiasedLock.class) {
                BiasedLock.class.notify();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (BiasedLock.class) {
                try {
                    BiasedLock.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("start {}", ClassLayout.parseInstance(d).toPrintable());
            synchronized (d) {
                log.info("in {}", ClassLayout.parseInstance(d).toPrintable());
            }
            log.info("end {}", ClassLayout.parseInstance(d).toPrintable());
        });
        thread2.start();
        thread2.join();
    }


}


// 关闭偏向锁延迟
//-XX:BiasedLockingStartupDelay=0
class BiasedLock {
    static final Object obj = new Object();

    public static void m1() {
        synchronized (obj) {
            // 同步块 A
            m2();
        }
    }

    public static void m2() {
        synchronized (obj) {
            // 同步块 B
            m3();
        }
    }

    public static void m3() {
        synchronized (obj) {
            // 同步块 C
        }
    }
}