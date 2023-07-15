package cn.dhx.mq.rabbitmq.java.workingmode.workqueues;

import cn.dhx.mq.rabbitmq.java.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;

public class Consumer2 {

    private final static String QUEUE_NAME="workqueue";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtil.getChannel();
        System.out.println("consumer 2  wait");
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.basicConsume(QUEUE_NAME,true,(consumerTag, message)->{
            String s = new String(message.getBody());
            System.out.println("-----" + s);
        },(consumerTag)->{

        });
    }
}
