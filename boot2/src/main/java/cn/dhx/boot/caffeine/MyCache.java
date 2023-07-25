package cn.dhx.boot.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.benmanes.caffeine.cache.RemovalCause;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/7/24 10:40
 */
@Slf4j
public class MyCache {


    @Test
    public void fun1() throws InterruptedException {
        LoadingCache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
//                .maximumSize(20)
                .removalListener((String key, String value, RemovalCause cause) -> {
                    log.info("Key {} was removed {}", key, cause);
                })
                .build(key -> UUID.randomUUID().toString());

        for (int i = 0; i < 19; i++) {
            cache.put(String.valueOf(i), "1");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        TimeUnit.SECONDS.sleep(10);
//        for (int i = 0; i < 19; i++) {
//            cache.put(String.valueOf(i)+"a", "1");
//            try {
//                TimeUnit.MILLISECONDS.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

            TimeUnit.SECONDS.sleep(100);



    }


    @Test
    public void fun2() {
        LoadingCache<String, Integer> cache = Caffeine.newBuilder().build(key -> {
            System.out.println("自动填充:" + key);
            return 18;
        });

        Integer age1 = cache.getIfPresent("张三");
        System.out.println(age1);

        // key 不存在时 会根据给定的CacheLoader自动装载进去
        Integer age2 = cache.get("张三");
        System.out.println(age2);
    }
}
