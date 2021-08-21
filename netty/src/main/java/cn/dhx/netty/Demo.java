package cn.dhx.netty;


import org.apache.rocketmq.common.message.Message;

public class Demo {
    public static void main(String[] args) {
        Message message = new Message("JmsConfig.TOPIC", "testtag", ("demo").getBytes());
        String s = message.toString();
        byte[] body = message.getBody();
        String bodyStr = new String(body);
        System.out.println(s);
        System.out.println(bodyStr);
    }
}
