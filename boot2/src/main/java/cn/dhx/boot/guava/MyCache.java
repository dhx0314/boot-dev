package cn.dhx.boot.guava;

import com.google.common.cache.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.Constants;
import org.junit.Test;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/7/12 16:12
 */
@Slf4j
public class MyCache {


    @Test
    public void fun1() {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                //缓存存储最大数量
//                .maximumSize(10)
                //访问过期时间3s
                .expireAfterAccess(10, TimeUnit.SECONDS)
                //监听删除
                .removalListener(notification -> System.out.println("删除监听：" + notification.getKey() + "=" + notification.getCause()))
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        //手动加载缓存
                        return "9999";
                    }
                });
//
//        cache.put("a", "1");
//        cache.put("b", "2");
//        cache.put("c", "3");
//        cache.put("d", "4");
//        cache.put("e", "5");
        for (int i = 0; i < 20; i++) {

            cache.put(String.valueOf(i), String.valueOf(i));

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
//            String a = cache.get("a");
//            System.out.println(a);

//            ConcurrentMap<String, String> map = cache.asMap();
//
//            map.forEach((k, v) -> {
//                log.info("key {} value {}", k, v);
//            });


//            String aa = cache.get("aa");
//            System.out.println(aa);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
