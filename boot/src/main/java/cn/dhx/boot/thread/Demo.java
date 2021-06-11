package cn.dhx.boot.thread;

import org.omg.CORBA.TIMEOUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Demo {


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(new Servicce("1","2"));
        TimeUnit.SECONDS.sleep(10);
        service.submit(new Servicce("1a","2a"));
    }


}
