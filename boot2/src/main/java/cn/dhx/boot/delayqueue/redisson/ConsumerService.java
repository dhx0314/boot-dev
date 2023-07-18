package cn.dhx.boot.delayqueue.redisson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author daihongxin
 * @create 2023/7/18 10:07
 */
@Slf4j
@Service
public class ConsumerService {


    @Autowired
    private RedisDelayQueueUtil redisDelayQueueUtil;

    @PostConstruct
    public void consumer() {
        new Thread(() -> {
            while (true) {
                try {
                    String delayQueue = redisDelayQueueUtil.getDelayQueue(RedisDelayQueueUtil.QUEUE_CODE);
                    log.info("delayQueue message {}", delayQueue);
                } catch (Exception e) {
                    log.info("error", e);
                }
            }
        }).start();
    }
}
