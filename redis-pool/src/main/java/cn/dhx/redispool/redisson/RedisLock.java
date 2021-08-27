package cn.dhx.redispool.redisson;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RedisLock {



    private  static String  STATION_LOCK_TAG = "station_lock";

    @Autowired
    private RedissonClient redissonClient;


    public boolean lock(String deviceId) {
        String key = generateKey(STATION_LOCK_TAG, deviceId);
        RLock fairLock = redissonClient.getFairLock(key);
        return fairLock.tryLock();
    }

    public void unlock(String deviceId) {
        String key = generateKey(STATION_LOCK_TAG, deviceId);
        RLock fairLock = redissonClient.getFairLock(key);
        fairLock.unlock();
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
