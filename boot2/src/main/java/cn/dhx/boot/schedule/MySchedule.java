package cn.dhx.boot.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author daihongxin
 * @create 2023/7/24 16:48
 */
@Slf4j
@Component
public class MySchedule {


    @Scheduled(cron = "${corn.tset:0/10 * * * * ?}")
    public void start() {
        log.info("=================================");
    }
}
