package cn.dhx.mq.rabbitmq.boot.service;


import cn.dhx.mq.rabbitmq.boot.config.DelayedQueueConfig;
import cn.dhx.mq.rabbitmq.boot.config.TtlQueueConfig;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class DeadLetterQueueConsumer {


    @RabbitListener(queues = TtlQueueConfig.DEAD_LETTER_QUEUE)
    public void receiveD(Message message, Channel channel) {

        String s = new String(message.getBody());
        log.info("{}-----message--{}",new Date(),s);
    }

    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE_NAME)
    public void receiveDelayedQueue(Message message) {
        String msg = new String(message.getBody());
        log.info("当前时间：{},收到延时队列的消息：{}", new Date().toString(), msg);

    }
}
