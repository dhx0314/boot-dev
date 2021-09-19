package cn.dhx.mq.rabbitmq.dead.ttl;

import cn.dhx.mq.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Produce {

    private final static String EXCHANGE_NAME = "normal_exchange";

    public static void main(String[] args) throws IOException, InterruptedException {
        Channel channel = RabbitMqUtil.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        // 设置消息的ttl时间
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().expiration("15000").build();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            String message = "info" + i;
            channel.basicPublish(EXCHANGE_NAME, "zhangshan", properties, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(message);
        }

    }

}
