package cn.dhx.mq.rabbitmq.persistent;

import cn.dhx.mq.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;

public class Consumer2 {

    private final static String QUEUE_NAME="workqueue";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtil.getChannel();
        System.out.println("consumer 2  wait");
        boolean durable=true;
        channel.queueDeclare(QUEUE_NAME,durable,false,false,null);
        channel.basicConsume(QUEUE_NAME,true,(consumerTag, message)->{
            String s = new String(message.getBody());
            System.out.println("-----" + s);
        },(consumerTag)->{

        });
    }
}
