package cn.dhx.mq.kafka.transaction;

import cn.dhx.mq.rocketmq.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

/**
 * @Author daihongxin
 * @create 2023/9/4 14:03
 */
@Slf4j
public class KafkaTransactionConsumerDemo {


    private static final String brokerList = "172.16.2.89:9092";
    private static final String topic = "tx_test";
    private static final String groupId = "group.demo";

    public static void main(String[] args) {
        try {

            Properties props = new Properties();
            props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);//分组ID
            //props.put("bootstrap.servers", brokerList);
            props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);//broker地址列表
            props.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, "read_uncommitted");//broker地址列表
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


    @Test
    public void consumer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.16.2.89:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, ConsumerConfig.DEFAULT_ISOLATION_LEVEL);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("my-topic"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
    }



}
