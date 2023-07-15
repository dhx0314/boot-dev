package cn.dhx.mq.rabbitmq.java.ttl.queue;

import cn.dhx.mq.rabbitmq.java.util.RabbitMqUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 *  先启动Consumer  关闭 Consumer
 *  启动 Produce  等待30s  启动 Consumer2
 */
public class Produce {

    private final static String EXCHANGE_NAME = "ttl_exchange_2";

    public static void main(String[] args) throws IOException, InterruptedException {
        Channel channel = RabbitMqUtil.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        for (int i = 0; i < 100; i++) {
            Thread.sleep(500);
            String message = "info" + i;
            channel.basicPublish(EXCHANGE_NAME, "zhangshan", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(message);
        }

    }

}
