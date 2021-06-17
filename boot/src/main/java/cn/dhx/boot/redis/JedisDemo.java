package cn.dhx.boot.redis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JedisDemo {

    @Test
    public void testCluster() throws IOException, InterruptedException {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("47.100.101.31", 7001));
        nodes.add(new HostAndPort("47.100.101.31", 7002));
        nodes.add(new HostAndPort("47.100.101.31", 7003));
        nodes.add(new HostAndPort("47.100.101.31", 7004));
        nodes.add(new HostAndPort("47.100.101.31", 7005));
        nodes.add(new HostAndPort("47.100.101.31", 7006));
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        JedisCluster cluster = new JedisCluster(nodes);

        JedisPool jedisPool = new JedisPool( "127.0.0.1", 6379);
//        Jedis resource = jedisPool.getResource();
        try {
            String res = cluster.get("name");
            System.out.println(res);
            cluster.close();
        } catch (Exception e) {
            e.printStackTrace();
            cluster.close();
        }
    }
}
