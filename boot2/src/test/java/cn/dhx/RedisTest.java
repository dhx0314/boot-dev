package cn.dhx;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
