package cn.dhx.redispool.old.jedisconfig.jedis;

import cn.dhx.redispool.old.jedisconfig.RedisPool;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolDemo {

        public static void main(String[] args) {
            JedisPool jedisPool = RedisPool.getJedisPoolInstance();
            Jedis jedis = null;

            try {
                jedis = jedisPool.getResource();
                jedis.set("k18", "v183222");
                String k18 = jedis.get("k18");
                System.out.println(k18);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                RedisPool.release(jedis);
            }
        }


}
