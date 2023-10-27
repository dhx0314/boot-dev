package cn.dhx;

import cn.dhx.boot.util.DateToolUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/10/18 11:55
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {


    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void fun1() {
        RLock lock = redissonClient.getLock("lock_10_18");
        lock.lock();

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fun2() throws Exception {
//        String aa = redisTemplate.opsForValue().get("aa");
//        System.out.println(aa);

        redisTemplate.opsForValue().set("aa", "bb", 600, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(30);
//        redisTemplate.opsForValue().set("aa", "cc", 600, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("aa", "cc");


        TimeUnit.SECONDS.sleep(300);
    }

    @Test
    public void fun3() throws Exception {
        redisTemplate.opsForHash().put("map", "k1", "v2");
        redisTemplate.expire("map", 600, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(30);

        redisTemplate.opsForHash().put("map", "k2", "v2");


        TimeUnit.SECONDS.sleep(300);

    }


    @Test
    public void fun333() {
        HashMap<String, Object> hashMap = new HashMap<>();
        RedisDTO redisDTO = new RedisDTO();
        redisDTO.setName("aa");


        String s = DateToolUtil.dateToStr(new Date());
        redisDTO.setDate(s);
        Map<String, Object> stringObjectMap = BeanUtil.beanToMap(redisDTO);
        redisTemplate.opsForHash().putAll("map2", stringObjectMap);

        Map<Object, Object> map21 = redisTemplate.opsForHash().entries("map2");
        RedisDTO redisDTO1 = BeanUtil.mapToBean(map21, RedisDTO.class, true, null);
        System.out.println(redisDTO1);
    }

}


@Data
class RedisDTO{
    private String name;
    private String date;
//    private Date date2;

}