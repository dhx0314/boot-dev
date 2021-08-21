package cn.dhx.redispool;

import cn.dhx.redispool.entity.CallDto;
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

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class RedisPoolApplicationTests {



    @Autowired
    private StringRedisTemplate redisTemplate;

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
