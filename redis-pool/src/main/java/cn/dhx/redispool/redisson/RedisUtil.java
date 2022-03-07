package cn.dhx.redispool.redisson;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisUtil {

    private static StringRedisTemplate stringRedisTemplate;

    private static RedisLock redisLock;

    @Autowired
    public  void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Autowired
    public  void setRedisLock(RedisLock redisLock) {
        this.redisLock = redisLock;
    }

    public static void fun1() {
        log.info("redisLock {}",redisLock);
        log.info("stringRedisTemplate {}" ,stringRedisTemplate);
        redisLock.lock("aa");
        redisLock.unlock("bb");
    }
}
