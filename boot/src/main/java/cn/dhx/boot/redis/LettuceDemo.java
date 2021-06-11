package cn.dhx.boot.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;

import java.util.ArrayList;

public class LettuceDemo {

    public static void main(String[] args) {
        // client
        RedisClient client = RedisClient.create("redis://localhost");

        // connection, 线程安全的长连接，连接丢失时会自动重连，直到调用 close 关闭连接。
        StatefulRedisConnection<String, String> connection = client.connect();

        ArrayList<RedisURI> list = new ArrayList<>();
        list.add(RedisURI.create("redis://192.168.37.128:7000"));
        list.add(RedisURI.create("redis://192.168.37.128:7001"));
        list.add(RedisURI.create("redis://192.168.37.128:7002"));
        list.add(RedisURI.create("redis://192.168.37.128:7003"));
        list.add(RedisURI.create("redis://192.168.37.128:7004"));
        list.add(RedisURI.create("redis://192.168.37.128:7005"));
        RedisClusterClient client2 = RedisClusterClient.create(list);
        //RedisClusterClient client = RedisClusterClient.create("redis://192.168.37.128:7000");
        StatefulRedisClusterConnection<String, String> connect2 = client2.connect();
    }
}
