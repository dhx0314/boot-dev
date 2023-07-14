package cn.dhx.boot.demo;

import cn.dhx.boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * @Author daihongxin
 * @create 2023/7/3 15:19
 */
@Slf4j
public class MyDemo {


    public static void main(String[] args) {
        Map<String, Map<String, Object>> map1 = new HashMap<>(4);
        Map<String, Map<String, Object>> map0 = new HashMap<>(4);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("test","testValue");

        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("test2","testValue2");

        HashMap<String, Object> hashMap3 = new HashMap<>();
        hashMap3.put("test3","testValue3");

        map1.put("a", hashMap);

        map1.put("a2", hashMap2);

        map0.put("a", hashMap3);
//        map0.put("a", hashMap2);

        log.info("map0 {}",map0);
        log.info("map1 {}",map1);

        log.info("--------------------");
        if (map1 != null) {
            map1.forEach((key, value) -> map0.computeIfAbsent(key, s -> new HashMap<>(4)).putAll(value));
        }

        log.info("map0 {}",map0);
        log.info("map1 {}",map1);



    }


    @Test
    public  void fun1() {
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
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(executorService.toString());
    }


}
