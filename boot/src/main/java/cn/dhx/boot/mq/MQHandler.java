package cn.dhx.boot.mq;

import java.util.concurrent.LinkedBlockingQueue;

public class MQHandler implements Runnable{

    private String string="";

    private LinkedBlockingQueue<String> mqQueue=null;


    public MQHandler(String string, LinkedBlockingQueue<String> mqQueue) {
        this.string = string;
        this.mqQueue = mqQueue;
    }


    @Override
    public void run() {
        String take = null;
        try {
            take = mqQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" "+take);
    }
}
