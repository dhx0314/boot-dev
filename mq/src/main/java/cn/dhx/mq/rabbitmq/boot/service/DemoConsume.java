package cn.dhx.mq.rabbitmq.boot.service;

import cn.dhx.mq.rabbitmq.boot.config.RabbitMqDemoConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @Author daihongxin
 * @create 2023/7/15 16:20
 */
@Slf4j
@Service
public class DemoConsume {

    //定义方法进行信息的监听   RabbitListener中的参数用于表示监听的是哪一个队列
    @RabbitListener(queues = RabbitMqDemoConfig.QUEUE_NAME)
    public void ListenerQueue(Message message) {

        byte[] body = message.getBody();
        String s = new String(body, StandardCharsets.UTF_8);
        log.info("consume message {}",s);
    }

}
