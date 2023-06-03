package cn.dhx.juc.juc.tool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/6/3 17:18
 */
@Slf4j
public class CountdownLatchDemo {

    @Test
    public void fun1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            log.info("begin");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            countDownLatch.countDown();
            log.info("end {}", countDownLatch.getCount());
        }).start();


        new Thread(() -> {
            log.info("begin");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            countDownLatch.countDown();
            log.info("end {}", countDownLatch.getCount());
        }).start();

        new Thread(() -> {
            log.info("begin");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            countDownLatch.countDown();
            log.info("end {}", countDownLatch.getCount());
        }).start();

        log.info("waiting");
        try {
            countDownLatch.await();
            log.info("wait end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TimeUnit.SECONDS.sleep(10);

    }
}
