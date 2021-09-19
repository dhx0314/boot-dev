package cn.dhx.boot.schedule;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class ScheduleDemo {


    @Scheduled(cron = "0/5 * * * * ?")
    public void fun2() {
        log.info("-------5 -start--------");

        log.info("-------5 -end--------");
    }


    @Scheduled(cron = "0/20 * * * * ?")
    public void fun3() {
        log.info("-------20 -start--------");
        try {
            TimeUnit.SECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("-------20 -end--------");
    }
}
