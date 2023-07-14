package cn.dhx.juc.share.tool.pool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/7/14 9:32
 */
@Slf4j
public class MyPool {


    @Test
    public void fun1() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                int j=1/0;
                log.info("current {}",Thread.currentThread().getName());
            });
        }
    }


    /**
     * current pool-1-thread-1  ,不会新建线程
     * @throws InterruptedException
     */
    @Test
    public void fun2() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{


                try {
                    int j=1/0;
                } catch (Exception e) {
                    log.error("",e);
                }
                log.info("current {}",Thread.currentThread().getName());
            });
        }

        TimeUnit.SECONDS.sleep(10);
    }
}
