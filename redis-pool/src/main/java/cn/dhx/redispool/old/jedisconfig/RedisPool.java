package cn.dhx.redispool.old.jedisconfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

    private static volatile JedisPool jedisPool = null;// 被volatile修饰的变量不会被本地线程缓存，对该变量的读写都是直接操作共享内存。

    private RedisPool() {

    }

    private static String url;

    private static String password;

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        RedisPool.password = password;
    }


    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        RedisPool.url = url;
    }


    public static JedisPool getJedisPoolInstance() {
        if (null == jedisPool) {
            synchronized (RedisPool.class) {
                if (null == jedisPool) {
                    String[] split = url.split("\\:");
                    String s = split[1];
                    int port = Integer.parseInt(s);
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxTotal(1000);
                    poolConfig.setMaxIdle(32);
                    poolConfig.setMaxWaitMillis(100 * 1000);
                    poolConfig.setTestOnBorrow(true);
                    if (null == password || "".equals(password)) {
                        jedisPool = new JedisPool(poolConfig, split[0], port);
                    }else {
                        jedisPool = new JedisPool(poolConfig, split[0], port,4000,password);
                    }

                }
            }
        }
        return jedisPool;
    }



    public static void release(final Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }


}
