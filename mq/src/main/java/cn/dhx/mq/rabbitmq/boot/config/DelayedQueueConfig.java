package cn.dhx.mq.rabbitmq.boot.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class DelayedQueueConfig {


    @Value("${delayedExchange.open}")
    String delayedExchangeStr;

    public static final String DELAYED_QUEUE_NAME = "delayed.queue";
    public static final String DELAYED_EXCHANGE_NAME = "delayed.exchange";
    public static final String DELAYED_EXCHANGE_NAME_DEMO = "delayed.exchange_demo";
    public static final String DELAYED_ROUTING_KEY = "delayed.routingkey";

    @Bean("delayedQueue")
    public Queue delayedQueue() {
        return new Queue(DELAYED_QUEUE_NAME);
    }


    // 延迟交换机
    @Bean("delayedExchange")
    public CustomExchange delayedExchange() {
        if ("1".equals(delayedExchangeStr)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("x-delayed-type","direct");
            return new CustomExchange(DELAYED_EXCHANGE_NAME,"x-delayed-message",true,false,hashMap);
        }else {
            return new CustomExchange(DELAYED_EXCHANGE_NAME_DEMO,"direct");
        }

    }


    @Bean
    public Binding bindingDelayedQueue(@Qualifier("delayedQueue") Queue queue, @Qualifier("delayedExchange") CustomExchange delayedExchange) {
        return BindingBuilder.bind(queue).to(delayedExchange).with(DELAYED_ROUTING_KEY).noargs();
    }
}
