package cn.dhx;

import cn.dhx.security.dao.UserMapper;
import cn.dhx.security.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author daihongxin
 * @create 2023/7/11 11:16
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void fun1() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }


    @Test
    public void fun12() {

        System.out.println(passwordEncoder.encode("1234"));
        System.out.println(passwordEncoder.encode("1234"));

    }
}
