package cn.dhx.mq.rabbitmq.confirm;

import cn.dhx.mq.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;

public class Produce {

    private final static String QUEUE_NAME="confirm";

    public static void main(String[] args) throws Exception {
            singleConfirmation();
            batchConfirmation();
    }


    public static void singleConfirmation() throws Exception {
        Channel channel = RabbitMqUtil.getChannel();
        channel.confirmSelect();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            String message="a"+i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            boolean b = channel.waitForConfirms();
            if (b) {
//                System.out.println("send success");
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("single cost "+(end-start));
    }


    public static void batchConfirmation() throws Exception {
        Channel channel = RabbitMqUtil.getChannel();

        int batchSize = 1000;
        int unconfirmedCount = 0;
        channel.confirmSelect();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            String message = "a" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            unconfirmedCount++;
            if (unconfirmedCount == batchSize) {
                channel.waitForConfirms();
                unconfirmedCount=0;
            }
        }

        if (unconfirmedCount > 0) {
            channel.waitForConfirms();
        }

        long end = System.currentTimeMillis();
        System.out.println("batch cost " + (end - start));
    }



}
