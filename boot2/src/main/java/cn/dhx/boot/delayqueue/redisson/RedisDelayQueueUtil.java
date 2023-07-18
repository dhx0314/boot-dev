package cn.dhx.boot.delayqueue.redisson;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/7/18 9:52
 */
@Slf4j
@Component
public class RedisDelayQueueUtil {

    public static final String QUEUE_CODE = "dhx";

    @Autowired
    private RedissonClient redissonClient;


    public <T> void addDelayQueue(T value, long delay, TimeUnit timeUnit, String queueCode){
        try {
            RBlockingDeque<Object> blockingDeque = redissonClient.getBlockingDeque(queueCode);
            RDelayedQueue<Object> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
            delayedQueue.offer(value, delay, timeUnit);
            log.info("(添加延时队列成功) 队列键：{}，队列值：{}，延迟时间：{} 秒", queueCode, value, timeUnit.toSeconds(delay) + "秒");
        } catch (Exception e) {
            log.error("(添加延时队列失败) {}", e.getMessage());
            throw new RuntimeException("(添加延时队列失败)");
        }
    }

    /**
     * 获取延迟队列
     * @param queueCode
     * @param <T>
     * @return
     * @throws InterruptedException
     */
    public <T> T getDelayQueue(String queueCode) throws InterruptedException {
        RBlockingDeque<Map> blockingDeque = redissonClient.getBlockingDeque(queueCode);
        T value  = (T) blockingDeque.take();
        return value;
    }

//    public <T> T removeDelayQueue(T value, String queueCode) {
//        RBlockingDeque<Object> blockingDeque = redissonClient.getBlockingDeque(queueCode);
//        RDelayedQueue<Object> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
//        delayedQueue.remove(value);
//        return value;
//    }

}
