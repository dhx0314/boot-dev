package cn.dhx.boot.demo;

import cn.dhx.boot.helper.ExecutorHelper;
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
    public void fun2() {

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        Integer code = (Integer) map.get("code");

        if (code != null && 0 == code) {
            System.out.println("Ok");
        }
    }


    @Test
    public void fun3() {
//        String str = "2023-07-24 15:10:00";
        String str = "2023-07-24";
        String[] s = str.split(" ");
        String s1 = s[0];
        System.out.println(s1);
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


}
