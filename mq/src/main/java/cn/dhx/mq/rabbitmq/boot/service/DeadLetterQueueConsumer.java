package cn.dhx.mq.rabbitmq.boot.service;


import cn.dhx.mq.rabbitmq.boot.config.DelayedQueueConfig;
import cn.dhx.mq.rabbitmq.boot.config.TTLQueueConfig;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class DeadLetterQueueConsumer {


    // 死信队列消费者
    @RabbitListener(queues = TTLQueueConfig.DEAD_LETTER_QUEUE)
    public void receiveD(Message message, Channel channel) {

        String s = new String(message.getBody());
        log.info("{}-----message--{}",new Date(),s);
    }


}
