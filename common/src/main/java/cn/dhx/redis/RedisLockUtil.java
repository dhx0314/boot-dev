package cn.dhx.redis;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/3/23 18:23
 */
@Slf4j
@Component
public class RedisLockUtil {

    private  static String  STATION_LOCK_TAG = "station_lock";

    @Autowired
    private RedissonClient redissonClient;


    public boolean lock(String deviceId) {
        String key = generateKey(STATION_LOCK_TAG, deviceId);
        RLock fairLock = redissonClient.getFairLock(key);
        return fairLock.tryLock();
    }

    public boolean lockTimeoutRelease(String deviceId,int timeOut) {
        String key = generateKey(STATION_LOCK_TAG, deviceId);
        RLock fairLock = redissonClient.getFairLock(key);
        try {
            boolean b = fairLock.tryLock(0, timeOut, TimeUnit.SECONDS);
            return b;
        } catch (InterruptedException e) {
            log.error("lockTimeout ",e);
        }
        return false;
    }


    public boolean lockTimeoutReleaseWait(String deviceId,int timeOut,int waitTime) {
        String key = generateKey(STATION_LOCK_TAG, deviceId);
        RLock fairLock = redissonClient.getFairLock(key);
        try {
            boolean b = fairLock.tryLock(waitTime, timeOut, TimeUnit.SECONDS);
            return b;
        } catch (InterruptedException e) {
            log.error("lockTimeout ",e);
        }
        return false;
    }

    public void unlock(String deviceId) {
        String key = generateKey(STATION_LOCK_TAG, deviceId);
        RLock fairLock = redissonClient.getFairLock(key);
        fairLock.unlock();
        log.info("unlock");
    }


    /**
     * 格式：aaa_bbb_ccc
     */
    private String generateKey(String... keys) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < keys.length; i++) {
            builder.append(keys[i]);
            if (i < keys.length - 1) {
                builder.append("_");
            }
        }
        return builder.toString().toLowerCase();
    }
}
