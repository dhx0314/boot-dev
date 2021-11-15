package cn.dhx.boot.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Demo9 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("Number of threads " + Thread.activeCount());
    }







}
