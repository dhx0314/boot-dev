package cn.dhx.juc.thread;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


@Slf4j
public class ThreadStage {

    public static void main(String[] args) {


        new Thread(()->{

        }).start();
        Thread thread1 = new Thread(() -> {

        });


        Thread thread2 = new Thread(() -> { //RUNNABLE
            while (true) {

            }
        });
        thread2.start();

        Thread thread3 = new Thread(() -> { //TERMINATED
            log.info("running");
        });
        thread3.start();

        Thread thread4 = new Thread(() -> { //TIMED_WAITING
            synchronized (ThreadStage.class) {
                try {
                    TimeUnit.SECONDS.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread4.start();

        Thread thread5 = new Thread(() -> { //TIMED_WAITING
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread5.start();

        Thread thread5_1 = new Thread(() -> { //TIMED_WAITING
            try {
                thread2.join(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread5_1.start();

        Thread thread6 = new Thread(() -> { //TIMED_WAITING
            synchronized (ThreadStage.class) {
                log.info("running");
            }
        });
        thread6.start();

        log.info("stage thread1 {}", thread1.getState());
        log.info("stage thread2 {}", thread2.getState());
        log.info("stage thread3 {}", thread3.getState());
        log.info("stage thread4 {}", thread4.getState());
        log.info("stage thread5 {}", thread5.getState());
        log.info("stage thread5_1 {}", thread5_1.getState());
        log.info("stage thread6 {}", thread6.getState());
    }
}
