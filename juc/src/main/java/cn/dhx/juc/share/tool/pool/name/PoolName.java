package cn.dhx.juc.share.tool.pool.name;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/6/9 11:47
 */
@Slf4j
public class PoolName {


    @Test
    public void fun1() throws InterruptedException {
        ThreadFactory springThreadFactory = new CustomizableThreadFactory("mySpringThread-pool-");
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                10,
                30,
                5,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(1000),
                springThreadFactory); //给线程池中的线程自定义名称

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                log.info("start");
            });
        }
        TimeUnit.SECONDS.sleep(10);

    }


    @Test
    public void fun2() throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                10,
                30,
                5,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(1000),
                new NamesThreadFactory("myPool")); //给线程池中的线程自定义名称

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                log.info("start");
            });
        }
        TimeUnit.SECONDS.sleep(10);

    }
}
