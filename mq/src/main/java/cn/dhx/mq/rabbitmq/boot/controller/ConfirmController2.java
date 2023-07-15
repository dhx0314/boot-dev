package cn.dhx.mq.rabbitmq.boot.controller;

import cn.dhx.mq.rabbitmq.boot.config.ConfirmConfig;
import cn.dhx.mq.rabbitmq.boot.service.MyCallBack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @Author daihongxin
 * @create 2023/7/15 23:24
 */
@Slf4j
@RestController
public class ConfirmController2 {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MyCallBack myCallBack;

    //依赖注入 rabbitTemplate 之后再设置它的回调对象
    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(myCallBack);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnsCallback(myCallBack);
    }


    @GetMapping("sendMessage2/{message}")
    public void sendMessage(@PathVariable("message") String message) {
        CorrelationData correlationData = new CorrelationData("1");
        String routeKey = "key1";

        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME, routeKey, message + routeKey, correlationData);
        log.info("sendMessage routeKey {}", message);

        CorrelationData correlationData2 = new CorrelationData("2");
        String routeKey2 = "key2";

        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME, routeKey2, message + routeKey2, correlationData2);

        log.info("sendMessage routeKey2 {}", message);

    }
}
