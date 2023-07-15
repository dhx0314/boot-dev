package cn.dhx.mq.rabbitmq.java.ack;

import cn.dhx.mq.rabbitmq.java.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private final static String QUEUE_NAME="ack_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtil.getChannel();
        System.out.println("consumer 1  wait");

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);



        //param1：prefetchSize，预取大小服务器将传递的最大内容量（以八位字节为单位），如果不受限制，则为0
        //默认值：0
        //param2：prefetchCount，服务器一次请求将传递的最大邮件数，如果没有限制，则为0
        //调用此方法时，该值必填。默认值：0
        //param3：global，是否将设置应用于整个频道，而不是每个消费者
        //默认值：false，应用于本身（一个消费者）
        //true：应用于整个频道
//        channel.basicQos(0,0,false);

//        订阅队列消息控制接收速率

        int prefetchCount = 1;
        channel.basicQos(prefetchCount);
        boolean autoAck=false;
        channel.basicConsume(QUEUE_NAME,autoAck,(consumerTag, message)->{

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
