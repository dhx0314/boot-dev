package cn.dhx.boot.demo;

import cn.dhx.boot.entity.User;
import cn.dhx.boot.helper.ExecutorHelper;
import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Author daihongxin
 * @create 2023/7/3 15:19
 */
@Slf4j
public class MyDemo<T> {




    private T a;

    public static void main(String[] args) {

        ScheduledFuture<?> scheduledFuture = ExecutorHelper.scheduleWithFixedDelay(() -> {
            log.info("Thread {}", Thread.currentThread().getName());
        }, 15, 6, TimeUnit.SECONDS);


        ScheduledFuture<?> scheduledFuture2 = ExecutorHelper.scheduleWithFixedDelay(() -> {
            log.info("scheduledFuture2 {}", Thread.currentThread().getName());
        }, 15, 6, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledFuture.cancel(true);


        try {
            TimeUnit.SECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void fun1() {
        // 创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射项
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // 计算 Shirt 的值
        int shirtPrice = prices.computeIfAbsent("Pant", key -> 280);
        System.out.println("Price of Shirt: " + shirtPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);

    }


    @Test
    public void fun2() throws InterruptedException {

        for (int i = 0; i < 4; i++) {
            User user = new User();
            user.setName(String.valueOf(i));
            ScheduledFuture<?> scheduledFuture = ExecutorHelper.schedule(() -> {
                log.info("Thread {} {}", Thread.currentThread().getName(),user.getName());
            }, 6, TimeUnit.SECONDS);
        }

        TimeUnit.SECONDS.sleep(100);
    }


    @Test
    public void fun3() throws InterruptedException {


        User user = new User();
        new Thread(()->{
            log.info("t1");
            synchronized (user.getLock()) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("t1 end");
            }
        }).start();

        new Thread(()->{
            log.info("t2");
            synchronized (user.getLock()) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("t2 end");
            }
        }).start();

        TimeUnit.SECONDS.sleep(100);

    }

    @Test
    public void fun4() {
//        String s = UUID.randomUUID().toString();

        String replace = UUID.fastUUID().toString().replace("-", "");
        System.out.println(replace);


    }


    public static <T> String funa() {

        T t;
        t = (T) "aa";
        System.out.println(t);
//        System.out.println(t);
        return "ok";
    }



    public static <T> String funa2(T t) {

//        T t;
//        t = (T) "aa";
        System.out.println(t);
//        System.out.println(t);
        return "ok";
    }


    @Test
    public void fun1aaa() {
        Cache<String,String> fifoCache = CacheUtil.newFIFOCache(3);
        fifoCache.put("1","a");
        fifoCache.put("2","a");
        fifoCache.put("3","a");
        fifoCache.put("4","a");

        System.out.println(fifoCache);
    }

}
