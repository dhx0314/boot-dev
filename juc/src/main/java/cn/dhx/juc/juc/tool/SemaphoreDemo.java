package cn.dhx.juc.juc.tool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/6/3 17:05
 */
@Slf4j
public class SemaphoreDemo {

    @Test
    public void fun1() throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    log.info("running");
                    TimeUnit.SECONDS.sleep(1);
                    log.info("ending");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(10);
    }


    @Test
    public void fun2() throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(100);
        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        new Thread(()->{
            while (true) {
                try {
                    semaphore.acquire();
                    log.info("start");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        TimeUnit.SECONDS.sleep(30);
    }

}
