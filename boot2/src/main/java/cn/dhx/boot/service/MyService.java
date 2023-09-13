package cn.dhx.boot.service;

import cn.dhx.boot.dao.UserDao;
import cn.dhx.boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author daihongxin
 * @create 2023/4/26 19:22
 */

@Component
@Slf4j
public class MyService {


    @Autowired
    private UserDao userDao;

    private static MyService instance;

    public MyService() {
        log.info("MyService start");
        instance = this;
    }

    public static MyService getInstance() {
        return instance;
    }

    @Transactional
    public void doSomething(String data) {
        User user = new User();
        user.setUserName("MyService");
        userDao.insert(user);
//        System.out.println(1 / 0);
    }
}
