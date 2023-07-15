package cn.dhx.mq.rabbitmq.java.ttl.queue;

import cn.dhx.mq.rabbitmq.java.util.RabbitMqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private final static String TTL_EXCHANGE_NAME="ttl_exchange_2";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtil.getChannel();
        System.out.println("consumer 2  wait");

        channel.exchangeDeclare(TTL_EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName="ttl-queue-2";


        HashMap<String, Object> params = new HashMap<>();
        params.put("x-message-ttl",5000);
        channel.queueDeclare(queueName, false, false, false, params);
        channel.queueBind(queueName,TTL_EXCHANGE_NAME,"zhangshan");

        channel.basicConsume(queueName,true,(consumerTag, message)->{
            String s = new String(message.getBody());
            System.out.println("-----" + s);
        },(consumerTag)->{
            System.out.println("----------");
        });



    }
}
