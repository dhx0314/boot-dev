package cn.dhx;

import cn.dhx.util.redis.RedisLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/3/23 18:28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MyTest {


    @Autowired
    private RedisLockUtil redisLockUtil;

    @Test
    public void lockTimeoutRelease() {
        boolean b = redisLockUtil.lockTimeoutRelease("11",60);
        log.info(" true {}",b);
        new Thread(()->{
            while (true) {
                boolean lock = redisLockUtil.lockTimeoutRelease("11",10);
                if (lock) {
                    log.info("true");
                    break;
                }else {
                    log.error("no get");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(70);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void lockTimeoutReleaseWait() {
        boolean b = redisLockUtil.lockTimeoutRelease("11",10);
        log.info(" true {}",b);
        new Thread(()->{
            while (true) {
                boolean lock = redisLockUtil.lockTimeoutReleaseWait("11",10,2);
                if (lock) {
                    log.info("true");
                    break;
                }else {
                    log.error("no get");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(70);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
