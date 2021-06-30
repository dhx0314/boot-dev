package cn.dhx.webflux;

import cn.dhx.webflux.Webclient.WebClientDemo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class WebfluxApplicationTests {


    @Autowired
    WebClientDemo webClientDemo;

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
