package cn.dhx.juc.share.monitor.method;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/13 15:55
 */
@Slf4j
public class WaitAndNotify {

    static final Object room = new Object();

    static boolean hasFlag = false;
    static boolean hasFlag2 = false;

    @Test
    public void waitAndNotify() throws InterruptedException {

        new Thread(() -> {
            synchronized (room) {
                log.info("flag start status {}", hasFlag);
                while (!hasFlag) {
                    log.info("flag is false ");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("flag status {}", hasFlag);
                if (hasFlag) {
                    log.info("flag is true doing");
                } else {
                    log.info("flag is false ");
                }

            }
        }, "1").start();

        new Thread(() -> {

            synchronized (room) {
                log.info("flag2 start status {}", hasFlag2);
                while (!hasFlag2) {
                    log.info("flag2 is false ");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("flag2 status {}", hasFlag2);
                if (hasFlag2) {
                    log.info("flag2 is true doing");
                } else {
                    log.info("flag2 is false ");
                }

            }
        }, "2").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (room) {
                    log.info("doing");
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            synchronized (room) {
                hasFlag = true;
                log.info("flag set true");
                room.notifyAll();
            }
        }).start();

        TimeUnit.SECONDS.sleep(10);
    }
}
