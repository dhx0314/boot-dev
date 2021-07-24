package cn.dhx.redispool.Redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;

public class RedisCluster {

    private volatile static JedisCluster jedisCluster;

    private RedisCluster() {
    }

    private static String url;

    private static String password;

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        RedisCluster.password = password;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        RedisCluster.url = url;
    }

    public static JedisCluster getInstance() {
        if (jedisCluster == null) {
            synchronized (RedisCluster.class) {
                if (jedisCluster == null) {
//                    String str = "172.16.2.95:7001,172.16.2.95:7002,172.16.2.95:7003,172.16.2.95:7004,172.16.2.95:7005,172.16.2.95:7006";
                    String[] split = url.split(",");
                    HashSet<HostAndPort> node = new HashSet<>();
                    for (String s : split) {
                        String[] split1 = s.split(":");
                        HostAndPort hostAndPort = new HostAndPort(split1[0], Integer.valueOf(split1[1]));
                        node.add(hostAndPort);
                    }

                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    // 最大空闲连接数, 默认8个
                    jedisPoolConfig.setMaxIdle(100);
                    // 最大连接数, 默认8个
                    jedisPoolConfig.setMaxTotal(500);
                    //最小空闲连接数, 默认0
                    jedisPoolConfig.setMinIdle(0);
                    // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
                    jedisPoolConfig.setMaxWaitMillis(4000); // 设置4秒
                    //对拿到的connection进行validateObject校验
                    jedisPoolConfig.setTestOnBorrow(true);
                    if (null == password || "".equals(password)) {
                        jedisCluster= new JedisCluster(node, jedisPoolConfig);
                    }else {
                        System.out.println("password");
                        jedisCluster = new JedisCluster(node, 4000, 4000, 3, "laihu", jedisPoolConfig);
                    }
                }
            }
        }
        return jedisCluster;
    }
}

