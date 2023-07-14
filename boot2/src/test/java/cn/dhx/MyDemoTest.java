package cn.dhx;

import cn.dhx.boot.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author daihongxin
 * @create 2023/7/13 17:17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MyDemoTest {


    @Autowired
    private MyService myService;


    @Test
    public void fun1() {
        System.out.println(myService.toString());
        System.out.println(MyService.getInstance());
    }
}
