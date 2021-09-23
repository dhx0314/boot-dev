package cn.dhx.redispool.web;


import cn.dhx.redispool.redisson.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class WebController {

    @Autowired
    RedisLock redisLock;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/add")
    public void fun2add() throws IOException {
        Long key = stringRedisTemplate.opsForValue().increment("key", 1);
        log.info("=="+key);
    }


    @GetMapping("/a234")
    public void fun2() throws IOException {
        Config config = redissonClient.getConfig();
        String s = config.toYAML();
        System.out.println(s);
        System.out.println("-----------------");
    }

    @GetMapping("/hi2")
    public String fun1a() {
        new Thread(() -> {
            if (redisLock.lock("a")) {
                try {
                    String name = Thread.currentThread().getName();
//                    log.info(name);
//                String lock = stringRedisTemplate.opsForValue().get("lock");
//                log.info(lock);
                    stringRedisTemplate.opsForValue().set("lock", name);
                    TimeUnit.SECONDS.sleep(3);
                    log.info("------------------redisLock.lock();-----");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    log.info("------------------redisLock.unlock();-----");
                    redisLock.unlock("a");
                }
            } else {
                log.info("no lock");
            }
        }).start();
        return "a";
    }


    @GetMapping("/hi")
    public void fun1() throws InterruptedException {

        new Thread(() -> {
            if (redisLock.lock("a")) {
                try {
                    String name = Thread.currentThread().getName();
//                    log.info(name);
                    String lock = stringRedisTemplate.opsForValue().get("lock");
                    log.info(lock);
                    stringRedisTemplate.opsForValue().set("lock", name);
                    TimeUnit.SECONDS.sleep(30);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    log.info("------------------redisLock.unlock();-----");
                    redisLock.unlock("a");
                }
            } else {

            }
        }).start();
        TimeUnit.SECONDS.sleep(5);
        String lock = stringRedisTemplate.opsForValue().get("lock");
        log.info(lock);
        stringRedisTemplate.opsForValue().set("lock", "name");
        String lock2 = stringRedisTemplate.opsForValue().get("lock");
        log.info(lock2);
//        new Thread(() -> {
//            if (redisLock.lock()) {
//                try {
//                    String name = Thread.currentThread().getName();
//                    log.info(name);
//                    String lock = stringRedisTemplate.opsForValue().get("lock");
//                    log.info(lock);
//                    stringRedisTemplate.opsForValue().set("lock", name);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    redisLock.unlock();
//                }
//            } else {
//
//            }
//        }).start();
    }


}
