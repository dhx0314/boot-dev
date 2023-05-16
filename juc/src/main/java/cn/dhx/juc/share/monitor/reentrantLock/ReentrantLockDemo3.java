package cn.dhx.juc.share.monitor.reentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author daihongxin
 * @create 2023/5/16 17:09
 */
@Slf4j
public class ReentrantLockDemo3 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();
    static volatile boolean flag1 = false;
    static volatile boolean flag2 = false;


    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                lock.lock();
                while (!flag1) {
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                log.info("flag1");
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                while (!flag2) {
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("flag2");
            } finally {
                lock.unlock();
            }
        }).start();


//        TimeUnit.SECONDS.sleep(5);
        log.info("start");
        TimeUnit.SECONDS.sleep(1);
        lock.lock();
        try {
            flag1 = true;
            condition1.signal();
        }finally {
            lock.unlock();
        }
        TimeUnit.SECONDS.sleep(1);
        log.info("start2");
        lock.lock();
        try {
            flag2 = true;
            condition2.signal();
        }finally {
            lock.unlock();
        }




    }
}


