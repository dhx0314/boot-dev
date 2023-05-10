package cn.dhx.juc.share.monitor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Hashtable;

/**
 * @Author daihongxin
 * @create 2023/5/10 20:07
 */

@Slf4j
public class Safe {

    static int counter = 0;
    static final Object room = new Object();

    @Test
    public void noSafe() throws InterruptedException {


        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                counter--;
            }
        });

        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        log.info("counter {}", counter);
    }


    @Test
    public void Safe() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (room) {
                    counter++;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized(room) {
                    counter--;
                }
            }
        });

        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        log.info("counter {}", counter);
    }
}
