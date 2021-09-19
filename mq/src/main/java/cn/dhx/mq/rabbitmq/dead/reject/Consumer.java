package cn.dhx.mq.rabbitmq.dead.reject;

import cn.dhx.mq.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private final static String EXCHANGE_NAME="normal_exchange";

    private final static String DEAD_EXCHANGE_NAME="dead_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtil.getChannel();
        System.out.println("consumer 1  wait");

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(DEAD_EXCHANGE_NAME,BuiltinExchangeType.DIRECT);
        // 声明死信队列
        String deadQueueName="dead-queue";
        channel.queueDeclare(deadQueueName,false,false,false,null);
        // 死信队列绑定死信交换机与routingkey
        channel.queueBind(deadQueueName,DEAD_EXCHANGE_NAME,"lisi");


        //正常队列绑定死信队列信息
        //正常队列设置死信交换机 参数 key 是固定值
        //正常队列设置死信 routing-key 参数 key 是固定值
        HashMap<String, Object> params = new HashMap<>();
        params.put("x-dead-letter-exchange", DEAD_EXCHANGE_NAME);
        params.put("x-dead-letter-routing-key","lisi");


        String queueName="nomal_queue";
        channel.queueDeclare(queueName, false, false, false, params);
        channel.queueBind(queueName,EXCHANGE_NAME,"zhangshan");

        channel.basicConsume(queueName,false,(consumerTag, message)->{
            String messageStr = new String(message.getBody());
            if (messageStr.equals("info5")) {
                System.out.println("-----reject message "+messageStr);
                //requeue 设置为 false 代表拒绝重新入队 该队列如果配置了死信交换机将发送到死信队列中
                channel.basicReject(message.getEnvelope().getDeliveryTag(), false);
            } else {
                System.out.println("-----" + messageStr);
                channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
            }

        },(consumerTag)->{
            System.out.println("----------");
        });



    }
}
