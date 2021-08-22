package cn.dhx.boot.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class MqMgr {
    LinkedBlockingDeque<String> strings = new LinkedBlockingDeque<>(10);
    ExecutorService executorService = Executors.newFixedThreadPool(16);


    public void fun1() {

    }

}
