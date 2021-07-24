package cn.dhx.redispool;

import cn.dhx.redispool.Redis.RedisCluster;
import redis.clients.jedis.JedisCluster;

public class Demo3 {
    public static void main(String[] args) {
        String str = "172.16.2.95:7001,172.16.2.95:7002,172.16.2.95:7003,172.16.2.95:7004,172.16.2.95:7005,172.16.2.95:7006";

        RedisCluster.setUrl(str);
        JedisCluster instance = RedisCluster.getInstance();
        instance.set("key1","v122222");
        String key1 = instance.get("key1");
        System.out.println(key1);
    }
}
