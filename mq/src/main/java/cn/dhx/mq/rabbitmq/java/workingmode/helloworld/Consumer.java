package cn.dhx.mq.rabbitmq.java.workingmode.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

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



        /**
         * 消费者消费消息
         * 1.消费哪个队列
         * 2.消费成功之后是否要自动应答 true 代表自动应答 false 手动应答
         * 3.推送的消息如何进行消费的接口回调
         * 3.消费者未成功消费的回调
         */
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //queue–队列的名称
        //autoAck–如果服务器应考虑消息在送达后得到确认，则为true；如果服务器应期望显式确认，则为false
        //deliveryCallback–传递消息时的回调
        //cancelCallback–取消消费者时的回调
        channel.basicConsume(QUEUE_NAME,true, (consumerTag,message)->{
            String s = new String(message.getBody());
            System.out.println("message-------"+s);

        },(consumerTag)->{
            System.out.println("消息消费被中断");
        });
//
//        channel.close();
//        connection.close();

    }
}
