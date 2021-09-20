package cn.dhx.mq.rabbitmq.java.dead.reject;

import cn.dhx.mq.rabbitmq.java.util.RabbitMqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Produce {

    private final static String EXCHANGE_NAME = "normal_exchange";

    public static void main(String[] args) throws IOException, InterruptedException {
        Channel channel = RabbitMqUtil.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);


        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            String message = "info" + i;
            channel.basicPublish(EXCHANGE_NAME, "zhangshan", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(message);
        }

    }

}
