package cn.dhx.redispool;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
class RedisPoolApplicationTests {


    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        HashMap<String, String> map = new HashMap<>();
//        map.put("k1","v1");
//        map.put("k2","v2");

        redisTemplate.opsForValue().set("k1","v22222");
        Object k11 = redisTemplate.opsForValue().get("k1");
        System.out.println(k11);
        String k1 = (String) redisTemplate.opsForValue().get("k1");
        System.out.println(k1);
//        String s = objectMapper.readValue(k1, String.class);
//        System.out.println(s);

        String k112 = stringRedisTemplate.opsForValue().get("k1");
        System.out.println(k112);
        stringRedisTemplate.opsForValue().set("sk1","sv1");
        String sk1 = stringRedisTemplate.opsForValue().get("sk1");
        System.out.println(sk1);
    }

}
