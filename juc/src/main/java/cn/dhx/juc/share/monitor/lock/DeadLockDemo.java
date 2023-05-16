package cn.dhx.juc.share.monitor.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/16 14:33
 * 死锁
 *
 */
@Slf4j
public class DeadLockDemo {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        new Thread(()->{
            synchronized (a) {
                log.info("lock a");
                synchronized (b) {
                    log.info("lock b");
                }
            }
        },"t1").start();

        new Thread(()->{
            synchronized (b) {
                log.info("lock b");
                synchronized (a) {
                    log.info("lock a");
                }
            }
        },"t2").start();

        new Thread(()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t3").start();
    }
}



