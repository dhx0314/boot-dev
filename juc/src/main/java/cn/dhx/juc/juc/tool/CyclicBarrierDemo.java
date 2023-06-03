package cn.dhx.juc.juc.tool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @Author daihongxin
 * @create 2023/6/3 17:23
 */
@Slf4j
public class CyclicBarrierDemo {


    @Test
    public void fun1() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        new Thread(() -> {
            log.info("start");
            try {
                TimeUnit.SECONDS.sleep(1);
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("runing");
        }).start();

        new Thread(() -> {
            log.info("start");
            try {
                TimeUnit.SECONDS.sleep(2);
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("runing");
        }).start();

        TimeUnit.SECONDS.sleep(20);
    }

    @Test
    public void fun2() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        log.info("main start");
        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                log.info("start");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                log.info("runing");
            });

            executorService.execute(() -> {
                log.info("start");
                try {
                    TimeUnit.SECONDS.sleep(2);
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                log.info("runing");
            });

        }
        TimeUnit.SECONDS.sleep(20);
    }
}
