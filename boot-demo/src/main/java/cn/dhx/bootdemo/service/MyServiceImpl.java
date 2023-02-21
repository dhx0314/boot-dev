package cn.dhx.bootdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service("abc")
@Slf4j
public class MyServiceImpl implements MyService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void send() {

        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("key1","value");
        log.info("---MyServiceImpl--abc--send-----");
    }



}
