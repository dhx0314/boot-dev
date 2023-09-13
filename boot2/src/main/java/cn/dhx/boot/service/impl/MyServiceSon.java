package cn.dhx.boot.service.impl;

import cn.dhx.boot.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author daihongxin
 * @create 2023/9/13 10:35
 */
@Slf4j
@Service
public class MyServiceSon extends MyService {


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void doSomething(String data) {
        super.doSomething(data);
    }
}
