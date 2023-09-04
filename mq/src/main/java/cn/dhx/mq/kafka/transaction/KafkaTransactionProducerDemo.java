package cn.dhx.mq.kafka.transaction;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.AuthorizationException;
import org.apache.kafka.common.errors.OutOfOrderSequenceException;
import org.apache.kafka.common.errors.ProducerFencedException;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author daihongxin
 * @create 2023/9/4 14:03
 */
@Slf4j
public class KafkaTransactionProducerDemo {


    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "172.16.2.89:9092");
        props.put("transactional.id", "my-transactional-id");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props, new StringSerializer(), new StringSerializer());

        producer.initTransactions();

        try {
            producer.beginTransaction();
            for (int i = 0; i < 10; i++) {
                producer.send(new ProducerRecord<>("my-topic", Integer.toString(i), Integer.toString(i)));
            }

            producer.commitTransaction();
        } catch (Exception e) {
            log.info("error",e);
            // For all other exceptions, just abort the transaction and try again.
            producer.abortTransaction();
        }
        producer.close();


    }


}
