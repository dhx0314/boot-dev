package cn.dhx.juc.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


@Slf4j
public class Daemon {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("start");
            }
        });
        //设置为守护线程
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        log.info("end");
    }
}
