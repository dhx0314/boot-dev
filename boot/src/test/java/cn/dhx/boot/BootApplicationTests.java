package cn.dhx.boot;

import cn.dhx.boot.demo.PkgProcessor;
import cn.dhx.boot.redis.DemoRedis;
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

}
