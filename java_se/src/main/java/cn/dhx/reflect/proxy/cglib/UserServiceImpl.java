package cn.dhx.reflect.proxy.cglib;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/9/1 10:29
 */
@Slf4j
public class UserServiceImpl {


    public void say() {
        log.info("say hello");
        say2();
    }

    public void say2() {
        log.info("say hello2");
    }

    public final void finalMethod() {
        log.info("final method");
    }

    public static void staticMethod() {
        log.info("static method");
    }
}
