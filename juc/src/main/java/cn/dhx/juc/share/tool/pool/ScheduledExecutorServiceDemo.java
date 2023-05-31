package cn.dhx.juc.share.tool.pool;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Slf4j
public class ScheduledExecutorServiceDemo {

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

    //2023-04-26 21:27:20   FixedRate
    //2023-04-26 21:27:25   FixedRate
    //2023-04-26 21:27:30   FixedRate
    //2023-04-26 21:27:35   FixedRate
    @Test
    public void scheduleAtFixedRate() throws InterruptedException {


        scheduledExecutorService.scheduleAtFixedRate(() -> {
            log.info("{}  FixedRate", DateUtil.now());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 5, TimeUnit.SECONDS);


        TimeUnit.SECONDS.sleep(1000);

    }

    //2023-04-26 21:28:10   FixedDelay
    //2023-04-26 21:28:18   FixedDelay
    //2023-04-26 21:28:26   FixedDelay
    //2023-04-26 21:28:34   FixedDelay
    @Test
    public void scheduleWithFixedDelay() throws InterruptedException {
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            log.info("{}  FixedDelay", DateUtil.now());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, 1, 5, TimeUnit.SECONDS);


        TimeUnit.SECONDS.sleep(1000);
    }
}
