package cn.dhx.juc.share.memory.happens;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;


/**
 * @Author daihongxin
 * @create 2023/5/18 18:46
 */
@Slf4j
public class HappensBefore {

    static int x = 0;

    @Test
    public void fun1() {
        Object m = new Object();
        new Thread(() -> {
            synchronized (m) {
                x = 10;
            }
        }, "t1").start();
        new Thread(() -> {
            synchronized (m) {
                System.out.println(x);
            }
        }, "t2").start();
    }


    volatile static int x2;

    @Test
    public void fun2() {
        new Thread(() -> {
            x2 = 10;
        }, "t1").start();
        new Thread(() -> {
            System.out.println(x2);
        }, "t2").start();
    }

    static int x3;

    @Test
    public void fun3() {
        x3 = 10;
        new Thread(() -> {
            System.out.println(x3);
        }, "t2").start();
    }

    static int x4;

    @Test
    public void fun4() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            x4 = 10;
        }, "t1");
        t1.start();
        t1.join();
        System.out.println(x4);
    }

    static int x5;

    @Test
    public void fun5() {

        Thread t2 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(x5);
                    break;
                }
            }
        }, "t2");
        t2.start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x5 = 15;
            t2.interrupt();
        }, "t1").start();
        while (!t2.isInterrupted()) {
            //会让出当前正在执行的线程的cpu执行权
            Thread.yield();
        }
        System.out.println(x5);
    }


    volatile static int x6;
    static int y;

    @Test
    public void fun6() {

        new Thread(() -> {
            y = 10;
            x6 = 20;
        }, "t1").start();
        new Thread(() -> {
            // x6=20 对 t2 可见, 同时 y=10 也对 t2 可见
            System.out.println(x6);
        }, "t2").start();
    }
}
