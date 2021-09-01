package cn.dhx.mq.rabbitmq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class Config {
    @PostConstruct
    public void init() {
        log.info("=================================================");
        log.info("==== RTVoice plugin version: " + 111);
        log.info("=================================================");

    }

}
