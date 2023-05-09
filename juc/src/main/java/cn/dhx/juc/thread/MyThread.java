package cn.dhx.juc.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

@Slf4j
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
            log.info("extends Thread");
        }

        public Thread1(String name) {
            super(name);
        }
    }


    static class Thread2 implements Runnable {

        @Override
        public void run() {
            log.info("implements Runnable");
        }
    }

}



