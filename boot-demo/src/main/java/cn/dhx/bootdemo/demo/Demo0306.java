package cn.dhx.bootdemo.demo;



import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/3/6 19:51
 */
public class Demo0306 {


    private final static ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(8, new NamedThreadFactory("FileCompressThreadPool"));


    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
