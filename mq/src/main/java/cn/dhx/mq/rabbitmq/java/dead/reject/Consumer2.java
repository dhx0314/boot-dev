package cn.dhx.mq.rabbitmq.java.dead.reject;

import cn.dhx.mq.rabbitmq.java.util.RabbitMqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {

    private final static String DEAD_EXCHANGE_NAME="dead_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtil.getChannel();
        System.out.println("consumer 2  wait");

        channel.exchangeDeclare(DEAD_EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName="dead-queue";
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName,DEAD_EXCHANGE_NAME,"lisi");

        channel.basicConsume(queueName,true,(consumerTag, message)->{
            String s = new String(message.getBody());
            System.out.println("-----" + s);
        },(consumerTag)->{
            System.out.println("----------");
        });



    }
}
