package cn.dhx.bootdemo.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo23 {

   static ExecutorService ThreadPool = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            fun1(i);
        }
    }




    public static void fun1(Object evt) {
        ThreadPool.execute(()->{
            onEvent(evt);
        });
    }

    public static void onEvent(Object evet) {
        System.out.println(Thread.currentThread().getName()+" "+evet);
    }
}
