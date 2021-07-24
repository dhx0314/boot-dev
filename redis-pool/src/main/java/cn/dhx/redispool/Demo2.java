package cn.dhx.redispool;

import cn.dhx.redispool.Redis.RedisCluster;
import redis.clients.jedis.JedisCluster;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo2 {




    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        long start=System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(10);


//        JedisCluster instance = RedisCluster.getInstance();
////                    instance.hset("map"+andDecrement,"k"+ finalI,String.valueOf(finalI));
//        Long k71 = instance.hdel("map-" + 7, "k71");
//        System.out.println(k71);
        for (int i = 0; i < 100; i++) {
            int andDecrement = atomicInteger.getAndDecrement();
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    int finalI = j;
                    JedisCluster instance = RedisCluster.getInstance();
                    instance.hset("map"+andDecrement,"k"+ finalI,String.valueOf(finalI));
//                    instance.hdel("map"+andDecrement,"k"+ finalI);
//                    instance.hdel("map"+andDecrement);
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();


        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
