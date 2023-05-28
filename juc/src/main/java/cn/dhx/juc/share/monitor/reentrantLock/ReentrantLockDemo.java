package cn.dhx.juc.share.monitor.reentrantLock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.locks.Condition;
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


    @Test
    public void fun1() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        try{
            lock.lock();
            condition.signal();
            System.out.println("----------------");
        }finally {
            lock.unlock();
        }

    }
}
