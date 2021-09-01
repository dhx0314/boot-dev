package cn.dhx.mq.rabbitmq.ack;

import cn.dhx.mq.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private final static String QUEUE_NAME="ack_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtil.getChannel();
        System.out.println("consumer 1  wait");

        channel.basicConsume(QUEUE_NAME,false,(consumerTag, message)->{
            String s = new String(message.getBody());
            System.out.println("-----" + s);
            /**
             * 1.消息标记 tag
             * 2.是否批量应答未应答消息
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        },(consumerTag)->{
            System.out.println("----------");
        });



    }
}
