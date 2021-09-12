package cn.dhx.mq.rabbitmq.exchange.topics;

import cn.dhx.mq.rabbitmq.util.RabbitMqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Produce {

    private final static String EXCHANGE_NAME="topic_logs";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtil.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,BuiltinExchangeType.TOPIC);
        HashMap<String, String> bindingKeyMap = new HashMap<>();
        bindingKeyMap.put("quick.orange.rabbit","被队列 Q1Q2 接收到");
        bindingKeyMap.put("lazy.orange.elephant","被队列 Q1Q2 接收到");
        bindingKeyMap.put("quick.orange.fox","被队列 Q1 接收到");
        bindingKeyMap.put("lazy.brown.fox","被队列 Q2 接收到");
        bindingKeyMap.put("lazy.pink.rabbit","虽然满足两个绑定但只被队列 Q2 接收一次");
        bindingKeyMap.put("quick.brown.fox","不匹配任何绑定不会被任何队列接收到会被丢弃");
        bindingKeyMap.put("quick.orange.male.rabbit","是四个单词不匹配任何绑定会被丢弃");
        bindingKeyMap.put("lazy.orange.male.rabbit","是四个单词但匹配 Q2");
        Set<Map.Entry<String, String>> entrySet = bindingKeyMap.entrySet();

        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String message = entry.getValue();
            channel.basicPublish(EXCHANGE_NAME, key,null, message.getBytes(StandardCharsets.UTF_8));
        }
    }
}
