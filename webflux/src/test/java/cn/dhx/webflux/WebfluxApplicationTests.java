package cn.dhx.webflux;

import cn.dhx.webflux.Controller.WebDemo;
import cn.dhx.webflux.Webclient.WebClientDemo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
class WebfluxApplicationTests {



    @Autowired
    WebClientDemo webClientDemo;

    @Autowired
    private WebDemo webDemo;

    @Test
    public void funa23() throws InterruptedException {
        webDemo.funmono();
//        webDemo.funmono2();
        TimeUnit.SECONDS.sleep(10);
    }





















    @Test
    public void fun1() {
        webClientDemo.fun1();
    }

    @Test
    public void fun2() {
        webClientDemo.fun2();
    }

    @Test
    public void fun3() {
        webClientDemo.fun3();
    }





}
