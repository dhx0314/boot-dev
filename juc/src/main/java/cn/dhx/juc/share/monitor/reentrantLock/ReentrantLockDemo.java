package cn.dhx.juc.share.monitor.reentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author daihongxin
 * @create 2023/5/16 17:09
 */
@Slf4j
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {

        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
        }
    }
}
