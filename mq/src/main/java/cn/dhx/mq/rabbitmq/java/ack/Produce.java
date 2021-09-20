package cn.dhx.mq.rabbitmq.java.ack;

import cn.dhx.mq.rabbitmq.java.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;

public class Produce {

    private final static String QUEUE_NAME="ack_queue";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtil.getChannel();


        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            channel.basicPublish("",QUEUE_NAME,null,next.getBytes());
            System.out.println("send --"+next);
        }
    }
}
