package cn.dhx.boot;

import cn.dhx.boot.demo.PkgProcessor;
import cn.dhx.boot.redis.DemoRedis;
import cn.dhx.boot.thread.Demo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class BootApplicationTests {

    @Autowired
    PkgProcessor pkgProcessor2;

    @Autowired
    DemoRedis demoRedis;

    @Autowired
    Demo demo;



    @Test
    void contextLoads() {

        PkgProcessor.getInstance().fun1();
        PkgProcessor instance = PkgProcessor.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(pkgProcessor2.hashCode());
    }


    @Test
    public void fun1() {
        demoRedis.fun1();
    }


    @Test
    public void fun3() {

        for (int i = 0; i < 3; i++) {
            new Thread(()-> {
                demo.fun1();
            },"a").start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

}
