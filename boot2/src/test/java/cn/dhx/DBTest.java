package cn.dhx;

import cn.dhx.boot.dao.UserDao;
import cn.dhx.boot.entity.User;
import cn.dhx.boot.util.JsonUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author daihongxin
 * @create 2023/10/7 10:01
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class DBTest {


    @Autowired
    private UserDao userDao;

    @Test
    public void fun1() {
        User user = userDao.selectById(1);
        System.out.println(user);
    }

    @Test
    public void fun2() {
        Page<User> userPage = new Page<>(2,10);
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<User>().orderByDesc(User::getId);
        Page<User> userPage1 = userDao.selectPage(userPage, userLambdaQueryWrapper);
        log.info("{}", JsonUtil.toString(userPage1));
    }


    @Test
    public void fun3() {
        PageHelper.startPage(2, 4);
        List<User> users = userDao.queryAll2();
        System.out.println(users);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        System.out.println(JsonUtil.toString(userPageInfo));
    }
}
