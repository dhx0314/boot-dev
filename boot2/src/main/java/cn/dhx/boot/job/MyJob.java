package cn.dhx.boot.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author daihongxin
 * @create 2023/10/27 14:27
 */
@Slf4j
@Component
public class MyJob {

//    @Scheduled(fixedRate = 60 * 1000, initialDelay = 20 * 1000)
    @Scheduled(fixedRate = 60 * 1000, initialDelay = 20 * 1000)
    public void fun1() {
        log.info("scheduled");
    }
}
