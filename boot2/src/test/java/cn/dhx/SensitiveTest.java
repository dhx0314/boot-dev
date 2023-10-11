package cn.dhx;

import cn.dhx.boot.sensitive.Person;
import cn.dhx.boot.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author daihongxin
 * @create 2023/10/11 15:53
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SensitiveTest {


    @Test
    public void fu1() {
        Person user = new Person();
        user.setRealName("不才陈某");
        user.setPhoneNumber("1979632820");
        user.setAddress("北京市东城2区长安街1号1234");
        user.setIdCard("4333333333334334333");
        log.info("{}", JsonUtil.toString(user));

    }
}
