package cn.dhx.mq.rabbitmq.boot.service;

import cn.dhx.mq.rabbitmq.boot.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author daihongxin
 * @create 2023/7/15 23:30
 */
@Slf4j
@Service
public class ConfirmConsumer {


    @RabbitListener(queues = ConfirmConfig.CONFIRM_QUEUE_NAME)
    public void receiveMsg(Message message) {
        String s = new String(message.getBody());
        log.info("confirm queue message {}", s);
    }
}
