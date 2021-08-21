package cn.dhx.redispool.Redis;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RedisDao {

    private static String type;

    private static String url;

    private static String password;

    private static JedisCluster jedisCluster;

    private static JedisPool jedisPool;

    public RedisDao(String type, String url, String password) {
        this.type = type;
        this.url = url;
        this.password = password;
        init();
    }

    public RedisDao(String type, String url) {
        this.type = type;
        this.url = url;
        init();
    }

    public void init() {
        // 0单例  1集群
        if ("0".equals(type)) {
            RedisPool.setUrl(url);
            RedisPool.setPassword(password);
            jedisPool = RedisPool.getJedisPoolInstance();
//            Util.info(this, "Redis  jedisPool start!", "");
        } else if ("1".equals(type)) {
            RedisCluster.setUrl(url);
            RedisCluster.setPassword(password);
            jedisCluster = RedisCluster.getInstance();
//            Util.info(this, "Redis  jedisCluster start!", "");
        } else {
            // type error
//            Util.warn(this, "Redis  type error!", "");
        }
    }

    public boolean setex(String tag, Object key, String value, int expireSeconds) {
        String setex = "";
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            setex = resource.setex(generateKey(tag, key), expireSeconds, value);
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
            setex = jedisCluster.setex(generateKey(tag, key), expireSeconds, value);
        } else {
            // type error
        }
        if (setex.equals("OK")) {
            return true;
        }

        return false;
    }



    public void setRedisData(String key, Object o) {
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            resource.set(key, o.toString());
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
            jedisCluster.set(key, o.toString());
        } else {
            // type error
        }
    }

    public static String getAgent(String key) {
        String string = "";
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            string = resource.get(key);
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
            string = jedisCluster.get(key);
        } else {
            // type error
        }
        return string;
    }



    public String get(String tag, String key) {
        String string = "";
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            string = resource.get(generateKey(tag, key));
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
            string = jedisCluster.get(generateKey(tag, key));
        } else {
            // type error
        }
        return string;
    }



    public boolean setRedisDataHash(String key, String filed1, Object o) {
        Gson gson = new Gson();
        String json = gson.toJson(o);
        long hset=1;
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            hset = resource.hset(key, filed1, json);
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
            hset=jedisCluster.hset(key, filed1, json);
        } else {
            // type error
        }

        if (hset == 0) {
            return true;
        }
        return false;
    }

    public void publish(String channel, String message) {
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            resource.publish(channel,message);
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
            jedisCluster.publish(channel,message);
        } else {
            // type error
        }
    }




    public String getRedisMap(String key, String filed1) {
        String json = "";
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            json = resource.hget(key, filed1);
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
            json = jedisCluster.hget(key, filed1);
        } else {
            // type error
        }
        return json;
    }

    public long hlen(String key) {
        long aLong = 0;
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            aLong = resource.hlen(key);
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
            aLong = jedisCluster.hdel(key);
        } else {
            // type error
        }
        return aLong;
    }


    public boolean hdel(String key, String filed1) {
        long hdel = 0;
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            hdel = resource.hdel(key, filed1);
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
            hdel = jedisCluster.hdel(key, filed1);
        } else {
            // type error
        }

        if (hdel == 0) {
            return false;
        }
        return true;
    }


    public boolean isAlive() {
        try {
            if ("0".equals(type)) {
                Jedis resource = jedisPool.getResource();
                resource.set("alive", "true");
                RedisPool.release(resource);
                return true;
            } else if ("1".equals(type)) {
                jedisCluster.set("alive", "true");
                return true;
            } else {
                // type error
                return false;
            }

        } catch (Exception e) {
//            Util.warn(this,"init Redis FAIL"+e.getMessage(), "");
            return false;
        }

    }


    public String getRedisData(String key) {
        String string = "";
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            string = resource.get(key);
        } else if ("1".equals(type)) {
            string = jedisCluster.get(key);
        } else {

        }
        return string;
    }

    protected String generateKey(String tag, Object key) {
        if (tag.equals("")) {
            return key.toString();
        }
        return key == null ? tag : tag + "|" + key;
    }


    public RedisDao() {

    }

//    public static String getType() {
//        return type;
//    }
//
//    public static void setType(String type) {
//        app.ctiServer.persistor.redis.RedisDao.type = type;
//    }
//
//    public static String getUrl() {
//        return url;
//    }
//
//    public static void setUrl(String url) {
//        app.ctiServer.persistor.redis.RedisDao.url = url;
//    }
//
//    public static String getPassword() {
//        return password;
//    }
//
//    public static void setPassword(String password) {
//        app.ctiServer.persistor.redis.RedisDao.password = password;
//    }
//
//    public static JedisCluster getJedisCluster() {
//        return jedisCluster;
//    }
//
//    public static void setJedisCluster(JedisCluster jedisCluster) {
//        app.ctiServer.persistor.redis.RedisDao.jedisCluster = jedisCluster;
//    }
//
//    public static JedisPool getJedisPool() {
//        return jedisPool;
//    }
//
//    public static void setJedisPool(JedisPool jedisPool) {
//        app.ctiServer.persistor.redis.RedisDao.jedisPool = jedisPool;
//    }
}
