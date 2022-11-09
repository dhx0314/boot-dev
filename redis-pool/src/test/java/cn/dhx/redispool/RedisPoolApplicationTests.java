package cn.dhx.redispool;

import cn.dhx.redispool.entity.CallDto;
import cn.dhx.redispool.redisson.RedisLock;
import cn.dhx.redispool.util.JsonUtil;
import cn.dhx.redispool.web.WebController;
import cn.dhx.util.pojo.Stu;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.hash.BeanUtilsHashMapper;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.rmi.CORBA.Stub;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class RedisPoolApplicationTests {


    @Autowired
    private StringRedisTemplate redisTemplate;
    //
//    @Autowired
//    private RedisTemplate redisTemplate2;
    @Autowired
    private RedisLock redisLock;


    @Test
    public void fun1test() {
        Stu stu = new Stu();
        stu.setAni("123");
        stu.setDnis("456");
        redisTemplate.opsForHash().put("a","c",JsonUtil.toString(stu));
        Object o = redisTemplate.opsForHash().get("a", "c");
        Stu stu1 = JsonUtil.toObject((String) o, Stu.class);
        System.out.println(stu1);


    }



    @Test
    public void funaa2() throws InterruptedException {
//        long expire = redisTemplate.opsForValue().getOperations().getExpire("key");
//        System.out.println(expire);

//        for (int i = 0; i < 5; i++) {
//            new Thread(()->{
//                boolean lock = redisLock.lock("2");
//                log.info("lock {} {}",Thread.currentThread().getName(),lock);
//            }).start();
//        }

//        redisLock.unlock("1");
//        redisLock.unlock("2");
//
//        TimeUnit.SECONDS.sleep(1000);

//        redisTemplate.opsForHash().put("map","k1","v1");
//        TimeUnit.SECONDS.sleep(15);
//        redisTemplate.opsForHash().put("map","k1","v2");

//        Boolean map = redisTemplate.delete("map");

//        Map<Object, Object> map = redisTemplate.opsForHash().entries("map");
        Boolean map1 = redisTemplate.hasKey("map");
        System.out.println(map1);
    }

    @Test
    public void fun234() {

        CallDto callDto = new CallDto();
        callDto.setCallid("awafawfe");
        callDto.setAni("3242");
        callDto.setGwMediaPort(1000);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("callid", callDto.getCallid());
        hashMap.put("ani", callDto.getAni());
        hashMap.put("gwMediaPort", "2000");
        BeanUtilsHashMapper beanUtilsHashMapper = new BeanUtilsHashMapper(CallDto.class);
        Map map = beanUtilsHashMapper.toHash(callDto);
        System.out.println(map);
//        String json = JsonUtil.toString(callDto);
//        HashMap<String, Object> hashMap = JsonUtil.toObject(json, HashMap.class);
        redisTemplate.opsForHash().putAll("hash", map);
        Map<Object, Object> hash = redisTemplate.opsForHash().entries("hash");

        String s = JsonUtil.toString(hash);
        CallDto callDto1 = JsonUtil.toObject(s, CallDto.class);
        System.out.println(callDto1);
//        rtVoiceRedisDaoUtil.setCallIdCache(callId, hashMap);
//        String s = redisTemplate.opsForValue().get("key222");
//        System.out.println(s);
    }


    @Autowired
    private WebController webController;


    @Test
    public void fun2() {
        Map<Object, Object> map = null;
        try {
            map = redisTemplate.opsForHash().entries("key");
        } catch (Exception e) {
            System.out.println("-----");
        }
        System.out.println(map);
    }

    @Test
    public void fun2aa() {
        String s = "";

        s = (String) redisTemplate.opsForHash().get("k1aa23423", "aa");
        System.out.println(s);


    }

    @Test
    public void fun1aa() {

        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("key0125", "mpsLocation", Duration.ofSeconds(100));
        System.out.println(aBoolean);

        Boolean aBoolean2 = redisTemplate.opsForValue().setIfAbsent("key1", "mpsLocation", Duration.ofSeconds(100));
        System.out.println(aBoolean2);

    }

    @Test
    public void fun1() {

        Object o = redisTemplate.opsForHash().entries("REC-AGENT|MPS-82");

        HashMap<Object, Object> stringStringHashMap = new HashMap<>();
        stringStringHashMap = (HashMap<Object, Object>) o;
        Object serviceType = stringStringHashMap.get("serviceType2");
        if (serviceType == null) {
            System.out.println("-------");
        } else {
            System.out.println("waefewafwa");
            System.out.println(serviceType.toString());
        }
//
//        try {
//            String deviceIpOld = (String) redisTemplate.opsForHash().get("REC-AGENT|MPS-82", "deviceId");
//            System.out.println(deviceIpOld);
//            if (StringUtils.isNotBlank(deviceIpOld)) {
//                System.out.println("---");
//            } else {
//                System.out.println("aaa");
//            }
//        } catch (Exception e) {
//            log.error("aa",e);
//            System.out.println("aa");
//        }

//        StringRedisTemplate object = SpringUtils.getObject(StringRedisTemplate.class);
//        redisTemplate=object;
//        String customCache = redisTemplate.opsForValue().get("customCache");
//        System.out.println(customCache);

//        for (int i = 0; i < 3; i++) {
//            String customCache = redisTemplate.opsForValue().get("customCache");
//
//            if (StringUtils.isBlank(customCache)) {
//                redisTemplate.opsForValue().set("customCache", "1");
//            } else {
//                redisTemplate.opsForValue().increment("customCache",100);
//            }
//            System.out.println(customCache);
//        }

//        Long key = redisTemplate.opsForValue().increment("key", 1);
//        incr("11",1L,"incr error");

//        Map<Object, Object> entries = redisTemplate.opsForHash().entries("REC-AGENT|MPS-144");
//        System.out.println(entries.toString());

//        String s = redisTemplate.opsForValue().get("11");


//        redisTemplate.opsForValue().set("k1","v2");
//        String s = redisTemplate.opsForValue().get("REC-AGENT|LicenseUsedNum");
//        System.out.println(s);
//        String channel="message-test";
//        String message="22";
//        redisTemplate.convertAndSend(channel, message);
//        System.out.println(s);
    }

    public Long incr(String key, long delta, String errMsg) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        try {
//            key = generateKey(key);
            redisTemplate.opsForValue().increment(key, delta);
            int i = 1 / 0;
            return 1L;
        } catch (Exception e) {
            log.error(errMsg, e);
        }
        return null;
    }


    @Test
    public void funwaef23() {
        ValueOperations<String, String> stringValueOperations = redisTemplate.opsForValue();
        for (int i = 30001; i < 30500; i++) {
            String key = "DEVICE-INFO-MAP" + "|" + i;
            String s = UUID.randomUUID().toString();
            stringValueOperations.set(key, s);
        }
    }


    @Test
    void contextLoads() {
//        getStationRecordingKey("");

        redisTemplate.opsForHash().put("REC-AGENT", "k1", "v1");

        Object k1 = redisTemplate.opsForHash().get("REC-AGENT", "k1");
        System.out.println(k1);
        String s = redisTemplate.opsForValue().get("REC-AGENT");
        System.out.println(s);
    }


    public ArrayList<String> getStationRecordingKey(String deviceId) {
        String tag = "REC-AGENT|station-recording:";
        String key = tag;
        if (StringUtils.isBlank(deviceId)) {
            key = tag;
        } else {
            key = tag + "*" + deviceId;
        }
        long start = System.currentTimeMillis();
        ArrayList<String> keys = new ArrayList<>();
        Cursor<String> cursor = scan(redisTemplate, key + "*", 200);
        while (cursor.hasNext()) {
            //找到一次就添加一次
            keys.add(cursor.next());
        }
        try {
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("getStationRecordingKey cost  [{}] ms", end - start);
        for (String s : keys) {
            System.out.println(s);
        }
        System.out.println(keys.size());
        return keys;
    }


    private static Cursor<String> scan(StringRedisTemplate stringRedisTemplate, String match, int count) {
        ScanOptions scanOptions = ScanOptions.scanOptions().match(match).count(count).build();
        RedisSerializer<String> redisSerializer = (RedisSerializer<String>) stringRedisTemplate.getKeySerializer();
        return (Cursor) stringRedisTemplate.executeWithStickyConnection((RedisCallback) redisConnection ->
                new ConvertingCursor<>(redisConnection.scan(scanOptions), redisSerializer::deserialize));
    }

}
