package cn.dhx.juc.share.monitor.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/16 15:32
 */
@Slf4j
public class LiveLockDemo {

    private static int count = 0;
    @Test
    public void liveLock() throws InterruptedException {
        new Thread(() -> {
            while (count >= 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                    log.info("count {}", count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }).start();

        new Thread(() -> {
            while (count < 20) {
                try {
                    log.info("count {}", count);
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
            }
        }).start();

        TimeUnit.SECONDS.sleep(10);
    }
}
