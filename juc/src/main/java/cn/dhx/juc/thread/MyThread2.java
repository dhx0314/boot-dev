package cn.dhx.juc.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MyThread2 {

    @Test
    public void FutureTask() throws Exception {
        FutureTask<Integer> task3 = new FutureTask<>(() -> {
            log.info("hello");
            return 100;
        });
        new Thread(task3).start();
//        主线程阻塞，同步等待 task 执行完毕的结果
        Integer integer = task3.get();
        System.out.println(integer);
    }


    /**
     * 在线程中debug
     */
    @Test
    public void fun2() {
        new Thread(()->{
            System.out.println("a");
        }).start();

        System.out.println("aa");
        System.out.println("aa2");

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
