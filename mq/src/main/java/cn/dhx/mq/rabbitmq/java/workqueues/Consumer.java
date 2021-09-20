package cn.dhx.mq.rabbitmq.java.workqueues;

import cn.dhx.mq.rabbitmq.java.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private final static String QUEUE_NAME="workqueue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtil.getChannel();
        System.out.println("consumer 1  wait");
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.basicConsume(QUEUE_NAME,true,(consumerTag, message)->{
            String s = new String(message.getBody());
            System.out.println("-----" + s);
        },(consumerTag)->{
            System.out.println("----------");
        });



    }
}
