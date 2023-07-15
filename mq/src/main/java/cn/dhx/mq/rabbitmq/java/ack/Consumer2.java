package cn.dhx.mq.rabbitmq.java.ack;

import cn.dhx.mq.rabbitmq.java.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Consumer2 {

    private final static String QUEUE_NAME="ack_queue";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtil.getChannel();
        System.out.println("consumer 2  wait");
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        boolean autoAck=false;


        // 不使用channel.BasicQos  消息全到消费端 消费端压力变大
        // 限流 处理慢处理的消息会更少
        int prefetchCount = 1;
//        channel.basicQos(prefetchCount);
        channel.basicConsume(QUEUE_NAME, autoAck,(consumerTag, message)->{
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s = new String(message.getBody());
            System.out.println("-----" + s);


            //参数1： 消费消息的index
            //参数2： 是否批量进行确认
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);

        },(consumerTag)->{

        });
    }
}
