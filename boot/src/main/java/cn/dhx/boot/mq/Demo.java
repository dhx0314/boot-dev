package cn.dhx.boot.mq;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

         LinkedBlockingQueue<String> mqQueue = new LinkedBlockingQueue<String>(2);
        mqQueue.add("2");
        mqQueue.add("3");
        mqQueue.add("4");
        mqQueue.add("5");


//        mqQueue.put("2");
//        mqQueue.put("4");
//        mqQueue.put("6");
//        mqQueue.put("8");

//        MqMgr mqMgr = new MqMgr();
//        mqMgr.init();
//        Random r = new Random(1);
//        for (int i = 0; i < 18; i++) {
//            int j = r.nextInt(1000);
//            String s=j+"";
//            mqMgr.addMessageToMqQueue(s);
//            TimeUnit.SECONDS.sleep(5);
//        }
//
//        TimeUnit.SECONDS.sleep(30);
//
//        for (int i = 0; i < 100; i++) {
//            int j = r.nextInt(1000);
//            String s=j+"";
//            mqMgr.addMessageToMqQueue(s);
//            TimeUnit.SECONDS.sleep(5);
//        }

    }
}
