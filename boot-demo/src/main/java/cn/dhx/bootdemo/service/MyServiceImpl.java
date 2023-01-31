package cn.dhx.bootdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("abc")
@Slf4j
public class MyServiceImpl implements MyService {

    @Override
    public void send() {
        log.info("---MyServiceImpl--abc--send-----");
    }

}