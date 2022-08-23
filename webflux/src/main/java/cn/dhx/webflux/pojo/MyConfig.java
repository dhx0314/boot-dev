package cn.dhx.webflux.pojo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MyConfig {

    @Value("${connector.login.reason-codes}")
    private String reasonCodes;

    @PostConstruct
    public void fun1() {
      log.info(reasonCodes);
    }
}
