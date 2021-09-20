package cn.dhx.mq.rabbitmq.boot.controller;


import cn.dhx.mq.rabbitmq.boot.config.DelayedQueueConfig;
import cn.dhx.mq.rabbitmq.boot.config.TtlQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class SendMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg/{message}")
    public String sendMsg(@PathVariable String message) {
        log.info("----{}----send {}----- ", new Date(), message);
        rabbitTemplate.convertAndSend(TtlQueueConfig.X_EXCHANGE,TtlQueueConfig.QUEUE_A_ROUTING_KEY,"消息来自 ttl 为 10S 的队列: "+message);
        rabbitTemplate.convertAndSend(TtlQueueConfig.X_EXCHANGE,TtlQueueConfig.QUEUE_B_ROUTING_KEY,"消息来自 ttl 为 40S 的队列: "+message);
        return "ok";
    }


    @GetMapping("/sendMsg/{message}/{ttlTime}")
    public String sendMsg(@PathVariable String message,@PathVariable String ttlTime) {
        log.info("----{}----send {}---ttlTime {}-- ", new Date(), message,ttlTime);
        rabbitTemplate.convertAndSend(TtlQueueConfig.X_EXCHANGE,TtlQueueConfig.QUEUE_C_ROUTING_KEY,"消息: "+message, correlationData ->{
            correlationData.getMessageProperties().setExpiration(ttlTime);
            return correlationData;
        });
        return "ok";
    }


    @GetMapping("sendDelayMsg/{message}/{delayTime}")
    public String sendMsg(@PathVariable String message,@PathVariable Integer delayTime) {
        log.info("----{}----send {}---ttlTime {}-- ", new Date(), message, delayTime);
        rabbitTemplate.convertAndSend(DelayedQueueConfig.DELAYED_EXCHANGE_NAME, DelayedQueueConfig.DELAYED_ROUTING_KEY, message,
                correlationData -> {
                    correlationData.getMessageProperties().setDelay(delayTime);
                    return correlationData;
                });
        return "ok";
    }
}
