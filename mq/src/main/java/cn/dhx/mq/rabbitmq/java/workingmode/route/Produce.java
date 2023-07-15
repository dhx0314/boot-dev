package cn.dhx.mq.rabbitmq.java.workingmode.route;

import cn.dhx.mq.rabbitmq.java.util.RabbitMqUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Produce {

    private final static String EXCHANGE_NAME="direct_logs";

    public static void main(String[] args) throws IOException {
        Channel channel = RabbitMqUtil.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,BuiltinExchangeType.DIRECT);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("info", "info  message");
        hashMap.put("warning", "warning message");
        hashMap.put("error", "error message");
        hashMap.put("debug","debug message");
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();

        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String message = entry.getValue();
            channel.basicPublish(EXCHANGE_NAME, key,null, message.getBytes(StandardCharsets.UTF_8));
        }
    }
}
