package cn.dhx.boot.demo;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/8/23 16:59
 */
@Slf4j
public class Demo2 {

    @Test
    public void fun1() {
        String str = "http://172.16.6.131:9503/record/updaterecord?event=1&agentid=1001&extnum=1001&starttime=2023-08-23 16:58:25&dir=0&caller=1001&called=1003&callid=c6d27b96-f714-4dfd-81ce-c15c666db64b";
        String post = HttpUtil.post(str, "");
        log.info("post {}",post);


        Thread thread;
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    }
}
