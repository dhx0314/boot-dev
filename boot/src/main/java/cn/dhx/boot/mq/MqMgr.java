package cn.dhx.boot.mq;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

//import com.alibaba.rocketmq.client.exception.MQClientException;
//import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
//import com.alibaba.rocketmq.common.message.Message;
//
//import component.util.Util;

public class MqMgr {

//    private DefaultMQProducer producer = null;
    private LinkedBlockingQueue<String> mqQueue = new LinkedBlockingQueue<String>();

    //创建一个固定线程个数的线程池
    private ExecutorService executor = Executors.newFixedThreadPool(16);




//    private String mqUrl;
//
//    public void setMqUrl(String mqUrl) {
//        this.mqUrl = mqUrl;
//    }

    public boolean init() {
        // mq need producter name and url
//        if (mqUrl == null || mqUrl.length() <= 4) return false;
//        Util.trace(this, "init mq connection,information details:%s", mqUrl);
//        Map<String, String> ret = parseMQUrl(mqUrl);
//        String producerName, instanceName, hostList;
//        if (ret != null && ret.size() >= 3) {
//            producerName = ret.get("producter");
//            instanceName = ret.get("instance");
//            hostList = ret.get("hostList");
//            try {
//                this.producer = new DefaultMQProducer(producerName);
//                producer.setInstanceName(instanceName);
//                producer.setNamesrvAddr(hostList);
//                producer.start();
//                Util.trace(this, "init mq connection success");


        String producer="";
                // 创建线程池
                for (int i = 0; i < 16; i++) {
                    executor.execute(new MQHandler(producer, mqQueue));
                }

                return true;
//            } catch (MQClientException e) {
//                // TODO Auto-generated catch block
//                producer = null;
//                Util.error(this, e, "connect to mq failed.address:%s", "");
//                e.printStackTrace();
//            }
//        }
//        return false;
    }

    public void addMessageToMqQueue(String message) {
        try {
            mqQueue.add(message);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private HashMap<String, String> parseMQUrl(String mqUrl) {
        // "$(producter)\\|$(instance)\\|$(hostList)"
        if (!mqUrl.isEmpty()) {
            String[] params = mqUrl.split("\\|");
            if (params.length >= 3) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("producter", params[0]);
                map.put("instance", params[1]);
                map.put("hostList", params[2]);
                return map;
            }
        }
        return null;
    }
}

