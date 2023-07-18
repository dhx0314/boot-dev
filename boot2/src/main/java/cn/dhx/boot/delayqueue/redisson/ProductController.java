package cn.dhx.boot.delayqueue.redisson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/7/18 10:12
 */
@Slf4j
@RestController
public class ProductController {


    @Autowired
    private RedisDelayQueueUtil redisDelayQueueUtil;


    @GetMapping("redisson/delay/add")
    public Object add() {
        redisDelayQueueUtil.addDelayQueue(UUID.randomUUID().toString(), 10, TimeUnit.SECONDS, RedisDelayQueueUtil.QUEUE_CODE);
        return "ok";
    }
}
