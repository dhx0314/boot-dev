package cn.dhx.mq.rabbitmq.java.workingmode.pubsub;

import cn.dhx.mq.rabbitmq.java.util.RabbitMqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;

public class Produce {

    private final static String EXCHANGE_NAME="fanout_logs";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtil.getChannel();
        /**
         * 声明一个 exchange
         * 1.exchange 的名称
         * 2.exchange 的类型
         */
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.next();
            channel.basicPublish(EXCHANGE_NAME,"",null,next.getBytes());
            System.out.println("send --"+next);
        }
    }
}
