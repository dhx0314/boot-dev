package cn.dhx;

import cn.dhx.security.dao.UserMapper;
import cn.dhx.security.entity.User;
import cn.dhx.security.mp.dao.SysUserDao;
import cn.dhx.security.mp.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

    @Autowired
    private SysUserDao sysUserDao;

    @Test
    public void fun1() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void fun2() {
        SysUser sysUser = sysUserDao.queryById(2L);
        System.out.println(sysUser);

        List<String> list = sysUserDao.selectPermsByUserId(2L);
        System.out.println(list);
    }




    @Test
    public void fun12() {

//        System.out.println(passwordEncoder.encode("1234"));
//        System.out.println(passwordEncoder.encode("1234"));

        String password = "$2a$10$MNapZHLrnDXgKp/L6XXTVORAiQM6T6L.StBYFOMKJ/RtQmGDa6Sc6";
        System.out.println(passwordEncoder.matches("1234",password));

    }
}
