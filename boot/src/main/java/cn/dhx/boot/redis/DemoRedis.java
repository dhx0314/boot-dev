package cn.dhx.boot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DemoRedis {

    @Autowired
    StringRedisTemplate redisTemplate;


    public void fun1() {
        String key="hash";
        redisTemplate.opsForValue().set("1","2");
        redisTemplate.opsForHash().put(key,"k1","v1");
        redisTemplate.opsForHash().put(key,"k2","v2");

        Boolean aBoolean = redisTemplate.opsForHash().putIfAbsent(key, "k1", "v1");
        Boolean aBoolean2 = redisTemplate.opsForHash().putIfAbsent(key, "k2", "v22");
        System.out.println(aBoolean);
        System.out.println(aBoolean2);
        Object k1 = redisTemplate.opsForHash().get(key, "k1");
        System.out.println(k1);
        redisTemplate.opsForHash().put(key,"k1","v333");
        Object k2 = redisTemplate.opsForHash().get(key, "k1");
        System.out.println(k2);
        redisTemplate.expire(key, 30, TimeUnit.SECONDS);
        System.out.println("--------------");
    }



}
