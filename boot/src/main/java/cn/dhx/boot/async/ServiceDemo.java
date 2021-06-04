package cn.dhx.boot.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;


@Service
public class ServiceDemo {


    public String getResult() {

        System.out.println("getResult() start...");
        System.out.println(new Date());

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date());
        System.out.println(Thread.currentThread().getName());
        System.out.println("getResult() end...");
        return "TestAsync";

    }
}
