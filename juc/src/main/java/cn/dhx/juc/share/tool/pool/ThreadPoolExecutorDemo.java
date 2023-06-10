package cn.dhx.juc.share.tool.pool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * @Author daihongxin
 * @create 2023/5/28 23:25
 */
@Slf4j
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        ExecutorService executorService1 = Executors.newCachedThreadPool();

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
    }


    @Test
    public void fun1() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(() -> {
            log.info("start");
        });

        Future<String> future = executorService.submit(() -> {
            return "aa";
        });
        try {
            String s = future.get();
            log.info("future {}", s);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Future<String> future1 = executorService.submit(() -> {
            System.out.println(1 / 0);
            return "randomStr";
        });

        try {
            String s = future1.get();
            log.info("future1 {}", s);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void error() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> {
            log.info("task");
            try {
                int i = 1 / 0;
            } catch (Exception e) {
                log.error("error ", e);
            }
        });


        Future<String> future = executorService.submit(() -> {
            log.info("task2");
            int i = 1 / 0;
            return "ok";
        });

        String s = future.get();
        log.info("future {}", s);

        TimeUnit.SECONDS.sleep(10);

    }

    @Test
    public void fun2() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                log.info("current {}", Thread.currentThread());
                int j = 1 / 0;
            });
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void fun3() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                log.info("current {}", Thread.currentThread());
                try {
                    int j = 1 / 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
