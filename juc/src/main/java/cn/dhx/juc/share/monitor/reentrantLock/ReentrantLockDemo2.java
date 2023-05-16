package cn.dhx.juc.share.monitor.reentrantLock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author daihongxin
 * @create 2023/5/16 17:09
 */
@Slf4j
public class ReentrantLockDemo2 {

    // 可重入
    @Test
    public void Reentrant() {
        LockDemo lockDemo = new LockDemo();
        lockDemo.method();
    }


    //可打断
    @Test
    public void interrupt() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread thread = new Thread(() -> {
            log.info("start");
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                log.info("lockInterruptibly");
                e.printStackTrace();
                return;
            }
            try {
                log.info("获得锁");
            } finally {
                lock.unlock();
            }

        });
        lock.lock();
        log.info("获得了锁");
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
            thread.interrupt();
            log.debug("执行打断");
        } finally {
            lock.unlock();
        }

        TimeUnit.SECONDS.sleep(10);

    }


    @Test
    public void interrupt2() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread thread = new Thread(() -> {
            log.info("start");
            try {
                lock.lock();
            } catch (Exception e) {
                log.info("lockInterruptibly");
                e.printStackTrace();
                return;
            }
            try {
                log.info("获得锁");
            } finally {
                lock.unlock();
            }

        });
        lock.lock();
        log.info("获得了锁");
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
            thread.interrupt();
            log.debug("执行打断");
        } finally {
            lock.unlock();
        }

        TimeUnit.SECONDS.sleep(10);

    }


    //锁超时
    @Test
    public void lockTimeOut() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread thread = new Thread(() -> {
            log.info("start");
            if (!lock.tryLock()) {
                log.info("get lock fail");
            } else {
                log.info("thread get lock");
            }
        });
        lock.lock();
        thread.start();
        try {
            log.info("get lock");
            TimeUnit.SECONDS.sleep(1);
        }finally {
            lock.unlock();
        }
    }


    //锁超时
    @Test
    public void lockTimeOut2() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread thread = new Thread(() -> {
            log.info("start");
            try {
                if (!lock.tryLock(2,TimeUnit.SECONDS)) {
                    log.info("get lock fail");
                } else {
                    log.info("thread get lock");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        lock.lock();
        thread.start();
        try {
            log.info("get lock");
            TimeUnit.SECONDS.sleep(3);
        }finally {
            lock.unlock();
        }
    }


    //公平锁
    @Test
    public void fairLock() throws InterruptedException {
        //默认不公平
        ReentrantLock lock = new ReentrantLock(true);
//        ReentrantLock lock = new ReentrantLock(false);
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                lock.lock();
                try {
                    log.info("1,running");
                }finally {
                    lock.unlock();
                }
            }).start();

        }

        TimeUnit.MILLISECONDS.sleep(2);
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                lock.lock();
                try {
                    log.info("2,running");
                }finally {
                    lock.unlock();
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(10);
    }
}


@Slf4j
class LockDemo {
    ReentrantLock lock = new ReentrantLock();

    public void method() {
        lock.lock();
        try {
            log.info("method");
            method1();
        } finally {
            lock.unlock();
        }

    }

    public void method1() {
        lock.lock();
        try {
            log.info("method1");
            method2();
        } finally {
            lock.unlock();
        }

    }

    public void method2() {
        lock.lock();
        try {
            log.info("method2");
        } finally {
            lock.unlock();
        }

    }
}
