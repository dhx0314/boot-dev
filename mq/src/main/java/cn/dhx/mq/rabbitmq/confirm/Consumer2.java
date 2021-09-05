package cn.dhx.mq.rabbitmq.confirm;

import cn.dhx.mq.rabbitmq.util.RabbitMqUtil;
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
        int prefetchCount = 4;
        channel.basicQos(prefetchCount);
        channel.basicConsume(QUEUE_NAME, autoAck,(consumerTag, message)->{
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s = new String(message.getBody());
            System.out.println("-----" + s);
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);

        },(consumerTag)->{

        });
    }
}
