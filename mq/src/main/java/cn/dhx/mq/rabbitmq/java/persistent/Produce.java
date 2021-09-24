package cn.dhx.mq.rabbitmq.java.persistent;

import cn.dhx.mq.rabbitmq.java.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Scanner;

public class Produce {

    private final static String QUEUE_NAME="persistent";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtil.getChannel();


        Boolean durable=true;
        channel.queueDeclare(QUEUE_NAME,durable,false,false,null);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            //消息的持久化
            channel.basicPublish("",QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,next.getBytes());
            System.out.println("send --"+next);
        }
    }
}
