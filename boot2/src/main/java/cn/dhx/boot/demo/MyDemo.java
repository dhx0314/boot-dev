package cn.dhx.boot.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author daihongxin
 * @create 2023/7/3 15:19
 */
@Slf4j
public class MyDemo {


    public static void main(String[] args) {

//        ExecutorService executor = Executors.newFixedThreadPool(2);
        int nThreads=2;
        ExecutorService executor = new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1));
        for (int i = 0; i < 5; i++) {
            try {
                executor.execute(()->{
                    try {
                        log.info("Thread name {}",Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

            } catch (Exception e) {
                log.error("error",e);
            }
        }
    }


    @Test
    public void fun1(){
        String regex="^1\\d{1,8}$";
        String ani = "1001";
        boolean matches = ani.matches(regex);
        System.out.println(matches);
    }
}
