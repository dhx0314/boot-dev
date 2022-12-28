package cn.dhx.bootdemo.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Demo06 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        semaphore.acquire();

        System.out.println("-------------------");
        TimeUnit.SECONDS.sleep(10);
        semaphore.release();
        System.out.println("--------------------");
//        ExecutorService executorService= Executors.newCachedThreadPool();
//        for (int i=0;i<10;i++){
//            executorService.execute(()->{
//                try {
//                    semaphore.acquire();
//                    semaphore.tryAcquire(5, TimeUnit.SECONDS);
//                    System.out.println(Thread.currentThread().getName()+" 进入!");
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }finally {
//                    semaphore.release();
//                    System.out.println(Thread.currentThread().getName()+" 释放!");
//                }
//            });
//        }
//        executorService.shutdown();
    }
}
