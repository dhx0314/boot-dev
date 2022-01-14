package cn.dhx.boot.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo17 {
    private static ExecutorService executor = Executors.newFixedThreadPool(1);


    //向kafka里推送消费
    public static void push2Kafka(Object msg) {
        System.out.println("--------------------------");
        executor.execute(() -> {
            try {
                //模拟 占用的内存大小
//                Byte[] bytes = new Byte[1024 * 1000 * 1000];
                Byte[] bytes = new Byte[1024];
                System.out.println(Thread.currentThread().getName() + "-->任务放到线程池:" + msg);
                int i=1/0;
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


    public static void push2Kafka2(Object msg) {
        System.out.println("--------------------------");
        executor.execute(() -> {

            //模拟 占用的内存大小
//                Byte[] bytes = new Byte[1024 * 1000 * 1000];
            Byte[] bytes = new Byte[1024];
            System.out.println(Thread.currentThread().getName() + "-->任务放到线程池:" + msg);
            int i=1/0;
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            push2Kafka2("aa" + i);
        }


    }
}
