package cn.dhx.boot.kafka;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Properties;


@Component
@Slf4j
public class KafkaProducerDemo {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    //自定义topic
    public static final String TOPIC_TEST = "mykafka";




    public void send(Object obj) {

        String obj2String = "test1111";
        log.info("准备发送消息为：{}", obj2String);
        //发送消息
//        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC_TEST,"22", obj2String);
//        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC_TEST,"22", "obj2String");

        ProducerRecord<String, String> stringStringProducerRecord = new ProducerRecord<>(TOPIC_TEST,"22", "aa");
        ListenableFuture send = kafkaTemplate.send(stringStringProducerRecord);
//        send.addCallback(((a)->{
//            System.out.println(a.toString());
//            System.out.println("----------------------");
//        }),((b)->{
//            System.out.println(b.toString());
//        }));
        send.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //发送失败的处理
                log.info(TOPIC_TEST + " - 生产者 发送消息失败：" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //成功的处理
                log.info(TOPIC_TEST + " - 生产者 发送消息成功：" + stringObjectSendResult.toString());
            }
        });

//
//        public ListenableFuture<SendResult<K, V>> send(ProducerRecord<K, V> record) {
//            Assert.notNull(record, "'record' cannot be null");
//            return this.doSend(record);
//        }









//        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send((Message<?>) stringStringProducerRecord);
//        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
//            @Override
//            public void onFailure(Throwable throwable) {
//                //发送失败的处理
//                log.info(TOPIC_TEST + " - 生产者 发送消息失败：" + throwable.getMessage());
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
//                //成功的处理
//                log.info(TOPIC_TEST + " - 生产者 发送消息成功：" + stringObjectSendResult.toString());
//            }
//        });


    }
}
