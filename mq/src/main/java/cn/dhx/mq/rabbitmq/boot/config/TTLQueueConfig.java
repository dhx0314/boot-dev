package cn.dhx.mq.rabbitmq.boot.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;


/**
 *<a href="https://imgse.com/i/pC57yQO">
 *     <img src="https://s1.ax1x.com/2023/07/15/pC57yQO.png" alt="pC57yQO.png" border="0" />
 *     </a>
 */
@Configuration
public class TTLQueueConfig {


    public static final String X_EXCHANGE = "X";
    public static final String QUEUE_A = "QA";
    public static final String QUEUE_B = "QB";
    public static final String QUEUE_A_ROUTING_KEY = "XA";
    public static final String QUEUE_B_ROUTING_KEY = "XB";
    public static final String Y_DEAD_LETTER_EXCHANGE = "Y";
    public static final String DEAD_LETTER_QUEUE = "QD";
    public static final String DEAD_LETTER_QUEUE_ROUTING_KEY = "YD";

    public static final String QUEUE_C = "QC";
    public static final String QUEUE_C_ROUTING_KEY = "XC";

    @Bean("xExchange")
    public DirectExchange exchangeX() {
        return new DirectExchange(X_EXCHANGE);
    }

    @Bean("yExchange")
    public DirectExchange exchangeY() {
        return new DirectExchange(Y_DEAD_LETTER_EXCHANGE);
    }

    // 声明队列 A ttl 为 10s 并绑定到对应的死信交换机
    @Bean("queueA")
    public Queue queueA() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        hashMap.put("x-dead-letter-routing-key",DEAD_LETTER_QUEUE_ROUTING_KEY);
        hashMap.put("x-message-ttl", 10000);
        return QueueBuilder.durable(QUEUE_A).withArguments(hashMap).build();
    }

    // 声明队列A绑定X交换机
    @Bean
    public Binding queueABindingX(@Qualifier("queueA") Queue queueA,@Qualifier("xExchange") DirectExchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with(QUEUE_A_ROUTING_KEY);
    }

    // 声明队列 B ttl 为 10s 并绑定到对应的死信交换机
    @Bean("queueB")
    public Queue queueB() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        hashMap.put("x-dead-letter-routing-key",DEAD_LETTER_QUEUE_ROUTING_KEY);
        hashMap.put("x-message-ttl", 40000);
        return QueueBuilder.durable(QUEUE_B).withArguments(hashMap).build();
    }

    // 声明队列A绑定X交换机
    @Bean
    public Binding queueBBindingX(@Qualifier("queueB") Queue queueB,@Qualifier("xExchange") DirectExchange xExchange) {
        return BindingBuilder.bind(queueB).to(xExchange).with(QUEUE_B_ROUTING_KEY);
    }

    // 声明死信队列QD
    @Bean
    public Queue queueD() {
        return new Queue(DEAD_LETTER_QUEUE);
    }

    // 声明队列A绑定X交换机
    @Bean
    public Binding queueDBindingY(@Qualifier("queueD") Queue queueD,@Qualifier("yExchange") DirectExchange yExchange) {
        return BindingBuilder.bind(queueD).to(yExchange).with(DEAD_LETTER_QUEUE_ROUTING_KEY);
    }


    // 声明队列 C
    @Bean("queueC")
    public Queue queueC() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        hashMap.put("x-dead-letter-routing-key",DEAD_LETTER_QUEUE_ROUTING_KEY);
        return QueueBuilder.durable(QUEUE_C).withArguments(hashMap).build();
    }

    // 声明队列c绑定X交换机
    @Bean
    public Binding queueCBindingX(@Qualifier("queueC") Queue queueC,@Qualifier("xExchange") DirectExchange xExchange) {
        return BindingBuilder.bind(queueC).to(xExchange).with(QUEUE_C_ROUTING_KEY);
    }






}
