package cn.dhx.redispool;

import cn.dhx.redispool.entity.CallDto;
import cn.dhx.redispool.web.WebController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class RedisPoolApplicationTests {



    @Autowired
    private StringRedisTemplate redisTemplate;





    @Autowired
    private WebController webController;

    @Test
    public void fun1() {
//        Long key = redisTemplate.opsForValue().increment("key", 1);
//        incr("11",1L,"incr error");

//        Map<Object, Object> entries = redisTemplate.opsForHash().entries("REC-AGENT|MPS-144");
//        System.out.println(entries.toString());

//        String s = redisTemplate.opsForValue().get("11");


        redisTemplate.opsForValue().set("k1","v2");
        String s = redisTemplate.opsForValue().get("REC-AGENT|LicenseUsedNum");
        System.out.println(s);
        String channel="message-test";
        String message="22";
        redisTemplate.convertAndSend(channel, message);
//        System.out.println(s);
    }

    public Long incr(String key, long delta, String errMsg) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        try {
//            key = generateKey(key);
             redisTemplate.opsForValue().increment(key, delta);
             int i=1/0;
            return 1L;
        } catch (Exception e) {
            log.error(errMsg, e);
        }
        return null;
    }


    @Test
    public void funwaef23() {
        ValueOperations<String, String> stringValueOperations = redisTemplate.opsForValue();
        for (int i = 30001; i <30500 ; i++) {
            String key="DEVICE-INFO-MAP"+"|"+i;
            String s = UUID.randomUUID().toString();
            stringValueOperations.set(key,s);
        }
    }



    @Test
    void contextLoads() {
//        getStationRecordingKey("");

        redisTemplate.opsForHash().put("REC-AGENT","k1","v1");

        Object k1 = redisTemplate.opsForHash().get("REC-AGENT", "k1");
        System.out.println(k1);
        String s = redisTemplate.opsForValue().get("REC-AGENT");
        System.out.println(s);
    }




    public ArrayList<String> getStationRecordingKey(String deviceId) {
        String tag ="REC-AGENT|station-recording:";
        String key=tag;
        if (StringUtils.isBlank(deviceId)) {
            key=tag;
        }else {
            key=tag+"*"+deviceId;
        }
        long start = System.currentTimeMillis();
        ArrayList<String> keys = new ArrayList<>();
        Cursor<String> cursor = scan(redisTemplate, key+"*", 200);
        while (cursor.hasNext()){
            //找到一次就添加一次
            keys.add(cursor.next());
        }
        try {
            cursor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("getStationRecordingKey cost  [{}] ms",end-start);
        for (String s : keys) {
            System.out.println(s);
        }
        System.out.println(keys.size());
        return keys;
    }


    private static Cursor<String> scan(StringRedisTemplate stringRedisTemplate, String match, int count){
        ScanOptions scanOptions = ScanOptions.scanOptions().match(match).count(count).build();
        RedisSerializer<String> redisSerializer = (RedisSerializer<String>) stringRedisTemplate.getKeySerializer();
        return (Cursor) stringRedisTemplate.executeWithStickyConnection((RedisCallback) redisConnection ->
                new ConvertingCursor<>(redisConnection.scan(scanOptions), redisSerializer::deserialize));
    }

}
