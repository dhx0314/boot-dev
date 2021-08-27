package cn.dhx.boot.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

public class RockerSend {

    public static void main(String[] args) throws Exception {
        //1 创建生成对象 指定生产组
        DefaultMQProducer producer = new DefaultMQProducer("cti-service");
        producer.setInstanceName("cti");
        //2 设置名字服务的地址
        producer.setNamesrvAddr("172.16.2.155:9876");
        //3 启动生成者
        producer.start();
        //4 创建一个消息
        Message message = new Message("01-hello", "hello,222rocketmq".getBytes("utf-8"));
        //5 发送消息
        producer.send(message);
        //6 关闭连接
        producer.shutdown();
    }

}
