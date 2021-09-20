package cn.dhx.mq.rabbitmq.java.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqUtil {

    public static Channel getChannel() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("121.5.218.105");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return channel;
    }
}
