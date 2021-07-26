package cn.dhx.redispool.Redis;

import cn.dhx.redispool.entity.RedisAgent;
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
        } else if ("1".equals(type)) {
            RedisCluster.setUrl(url);
            RedisCluster.setPassword(password);
            jedisCluster = RedisCluster.getInstance();
        } else {
            // type error
        }
    }



    public static void set2(String key, Object o) {
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            String set = resource.set(key, o.toString());
            System.out.println(set);
            if (set.equals("OK")) {
                System.out.println("-----------------------------");
            }
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
//                jedisCluster.setex(key,JSONUtil.objectToString(o),4*3600);
            jedisCluster.set(key, o.toString());
        } else {
            // type error
        }
    }


    public void setRedisData(String key, Object o) {
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            String set = resource.set(key, o.toString());
            System.out.println(set);
            if (set.equals("OK")) {
                System.out.println("-----------------------------");
            }
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
//                jedisCluster.setex(key,JSONUtil.objectToString(o),4*3600);
            jedisCluster.set(key, o.toString());
        } else {
            // type error
        }
    }

    public void setex(String tag, Object key, String value, int expireSeconds) {
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            resource.setex(generateKey(tag, key), expireSeconds, value);
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
            jedisCluster.setex(generateKey(tag, key), expireSeconds, value);
        } else {
            // type error
        }
    }


    public String get(String tag, Object key) {
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


    public String getRedisData(String key, Object o) {
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


    public void setRedisDataHash(String key, String filed1, Object o) {
        Gson gson = new Gson();
        String json = gson.toJson(o);
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            resource.hset(key, filed1, json);
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
            jedisCluster.hset(key, filed1, json);
        } else {
            // type error
        }
    }


    public Map<String, RedisAgent> getRedisAgentMaps(String key) {
        HashMap<String, RedisAgent> hashMap = new HashMap<String, RedisAgent>();
        Map<String, String> map = null;
        Gson gson = new Gson();
        if ("0".equals(type)) {
            Jedis resource = jedisPool.getResource();
            map = resource.hgetAll(key);
            RedisPool.release(resource);
        } else if ("1".equals(type)) {
            map = jedisCluster.hgetAll(key);
        } else {
            // type error
        }

        if (map != null && map.size() > 0) {
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                String key1 = entry.getKey();
                String value = entry.getValue();
                RedisAgent redisAgent = gson.fromJson(value, RedisAgent.class);
                hashMap.put(key1, redisAgent);
            }
        }
        return hashMap;
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

    public long getMapLen(String key) {
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


    public boolean removeRedisAgent(String key, String filed1) {
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
//                jedisCluster.setex(key,JSONUtil.objectToString(o),4*3600);
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
        return key == null ? tag : tag + "|" + key;
    }

    public RedisDao() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
