package cn.dhx;

import cn.dhx.boot.dao.UserDao;
import cn.dhx.boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author daihongxin
 * @create 2023/9/8 15:43
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyDateTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void fun1() {
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }
}
