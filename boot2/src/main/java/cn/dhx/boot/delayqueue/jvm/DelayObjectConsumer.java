package cn.dhx.boot.delayqueue.jvm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.DelayQueue;

/**
 * @Author daihongxin
 * @create 2023/7/17 10:09
 */
@Slf4j
@Service
public class DelayObjectConsumer {


    @Autowired
    private DelayQueue<OrderDelayObject> orderDelayQueue;


    @PostConstruct
    public void consumer() {
        new Thread(() -> {
            while (true) {
                try {
                    OrderDelayObject take = orderDelayQueue.take();
                    log.info("OrderDelayObject {}", take);
                } catch (Exception e) {
                    log.info("error ", e);
                }

            }
        }).start();

    }
}
