package cn.dhx.mq.kafka.simple;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @Author daihongxin
 * @create 2023/8/17 10:28
 */
@Slf4j
public class KafkaConsumerDemo {

    private static final String brokerList = "172.16.2.89:9092";
    private static final String topic = "test";
    private static final String groupId = "group.demo";

    @Test
    public void fun1() {
        consumer();
    }

    @Test
    public void fun2() {
        consumer();
    }

    public static void consumer() {
        try {

            Properties props = new Properties();
            props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);//分组ID
            //props.put("bootstrap.servers", brokerList);
            props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);//broker地址列表
            props.setProperty("enable.auto.commit", "true");
            props.setProperty("auto.commit.interval.ms", "1000");
            props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


            KafkaConsumer consumer = new KafkaConsumer<String, String>(props);
            consumer.subscribe(Collections.singletonList(topic));//topic列表
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(3000));
                for (ConsumerRecord<String, String> record : records) {
                    log.info(record.topic() + ":" + record.offset() + ":" + record.value());
                }

            }
        } catch (Exception e) {
            log.error("Exception",e);

        }
    }

}
