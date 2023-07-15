package cn.dhx.mq.rabbitmq.java.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqUtil {

    public static Channel getChannel() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.2.89");
        factory.setUsername("test");
        factory.setPassword("123456");
        Connection connection;
        Channel channel = null;
        try {
            //获取TCP长连接
            connection = factory.newConnection();
            ////创建通信“通道”，相当于TCP中的虚拟连接
            channel = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return channel;
    }
}
