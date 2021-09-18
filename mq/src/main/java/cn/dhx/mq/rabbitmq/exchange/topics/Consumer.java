package cn.dhx.mq.rabbitmq.exchange.topics;

import cn.dhx.mq.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private final static String EXCHANGE_NAME="topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtil.getChannel();
        System.out.println("consumer 1  wait");

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        String queueName="Q1";
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName,EXCHANGE_NAME,"*.orange.*");

        channel.basicConsume(queueName,true,(consumerTag, message)->{
            String s = new String(message.getBody());
            System.out.println("-----" + s);
        },(consumerTag)->{
            System.out.println("----------");
        });



    }
}
