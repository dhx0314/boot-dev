package cn.dhx.juc.a2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {

//        ExecutorService es1 = Executors.newSingleThreadExecutor();
        ExecutorService es1 = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            es1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正在执行任务");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        es1.shutdown();
    }
}
