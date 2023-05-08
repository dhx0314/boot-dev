package cn.dhx.juc.thread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class MyThread {

    @Test
    public void fun1() {
        new Thread1("extends-1").start();
        new Thread(new Thread2(),"Runnable Thread-1").start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Thread1 extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " extends Thread");
        }

        public Thread1(String name) {
            super(name);
        }
    }


    static class Thread2 implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " implements Runnable");
        }
    }

}



