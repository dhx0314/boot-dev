package cn.dhx.mq.rabbitmq.boot.service;

import cn.dhx.mq.rabbitmq.boot.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author daihongxin
 * @create 2023/7/15 22:24
 */
@Slf4j
@Service
public class DelayedQueueConsumer {

    // 延迟队列消费者
    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE_NAME)
    public void receiveDelayedQueue(Message message) {
        String msg = new String(message.getBody());
        log.info("当前时间：{},收到延时队列的消息：{}", new Date().toString(), msg);

    }
}
