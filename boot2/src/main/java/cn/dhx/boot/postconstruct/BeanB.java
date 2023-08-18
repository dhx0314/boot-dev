package cn.dhx.boot.postconstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author daihongxin
 * @create 2023/8/14 16:58
 */
@Slf4j
@Service
public class BeanB {

    private String name;

    @PostConstruct
    private void init() {
        log.info("这是BeanB 的init 方法");
    }

    @Autowired
    public void setName() {
        log.info("这是BeanB 的Autowired");
        this.name = "beanB";
    }

    public BeanB() {
        log.info("这是Bean B的 构造方法");
    }

    void testB() {
        log.info("这是BeanB 的 testB 方法");

    }
}
