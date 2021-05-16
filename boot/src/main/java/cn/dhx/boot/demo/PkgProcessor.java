package cn.dhx.boot.demo;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class PkgProcessor extends Thread {

    private static volatile PkgProcessor instance;

    private PkgProcessor() {
//        setName("PkgProcessor-Thread");
        instance = this;
    }

    public static PkgProcessor getInstance() {
        return instance;
    }

    public void fun1() {
        System.out.println("----------fun1");
    }

}