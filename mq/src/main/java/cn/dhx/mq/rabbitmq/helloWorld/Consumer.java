package cn.dhx.mq.rabbitmq.helloWorld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Delivery;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private final static String QUEUE_NAME="hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("121.5.218.105");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        System.out.println("---------sonsumer");
        channel.basicConsume(QUEUE_NAME,true, (consumerTag,message)->{
            String s = new String(message.getBody());
            System.out.println("message-------"+s);

        },(consumerTag)->{
            System.out.println("消息消费被中断");
        });

        channel.close();
        connection.close();

    }
}
