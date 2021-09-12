package cn.dhx.mq.rabbitmq.exchange.direct;

import cn.dhx.mq.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {

    private final static String EXCHANGE_NAME="direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtil.getChannel();
        System.out.println("consumer 2  wait");
        /**
         * 生成一个临时的队列 队列的名称是随机的
         * 当消费者断开和该队列的连接时 队列自动删除
         */
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName="console";
        channel.queueDeclare(queueName, false, false, false, null);
        //把该临时队列绑定我们的 exchange 其中 routingkey(也称之为 binding key)为空字符串
        channel.queueBind(queueName,EXCHANGE_NAME,"info");
        channel.queueBind(queueName,EXCHANGE_NAME,"warning");

        channel.basicConsume(queueName,true,(consumerTag, message)->{
            String s = new String(message.getBody());
            System.out.println("-----" + s);
        },(consumerTag)->{
            System.out.println("----------");
        });



    }
}
