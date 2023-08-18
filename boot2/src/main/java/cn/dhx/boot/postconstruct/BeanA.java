package cn.dhx.boot.postconstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author daihongxin
 * @create 2023/8/14 16:57
 */
@Slf4j
@Service
public class BeanA {


    @Autowired
    private BeanB beanB;

    private static String name;

    public BeanA() {
        log.info("这是Bean A 的构造方法");
    }

    static {
        log.info("name {}", name);
        log.info("这是BeanA的 static 方法");
    }

    @Autowired
    public void setName() {
        log.info("这是BeanA 的Autowired");
        this.name = "beanA";
    }


    @PostConstruct
    private void init() {
        log.info("这是BeanA的 init 方法");
        beanB.testB();
    }

}
