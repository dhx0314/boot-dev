package cn.dhx.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/16 11:14
 */
@Slf4j
public class MyTest2 {

    public static void main(String[] args) {

        new Thread(()->{

            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    log.info("start");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"myThread_test").start();
    }
}
