package cn.dhx.mybatis.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class LogTest {

    @Test
    public void fun1() {
        String s="demo";
        log.info("[ {} ]",s);
    }
}
