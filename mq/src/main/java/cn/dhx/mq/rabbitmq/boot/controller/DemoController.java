package cn.dhx.mq.rabbitmq.boot.controller;

import cn.dhx.mq.rabbitmq.boot.config.RabbitMqDemoConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author daihongxin
 * @create 2023/7/15 16:17
 */
@Slf4j
@RestController
public class DemoController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send/demo")
    public String send() {
        String s = UUID.randomUUID().toString();
        log.info("convertAndSend {}",s);
        rabbitTemplate.convertAndSend(RabbitMqDemoConfig.EXCHANGE_NAME,"boot.demo",s);
        return "ok";
    }
}
