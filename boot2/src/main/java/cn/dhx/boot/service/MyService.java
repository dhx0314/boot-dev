package cn.dhx.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author daihongxin
 * @create 2023/4/26 19:22
 */

@Component
@Slf4j
public class MyService {

    private static MyService instance;

    public MyService() {
        log.info("MyService start");
        instance = this;
    }

    public static MyService getInstance() {
        return instance;
    }
}
