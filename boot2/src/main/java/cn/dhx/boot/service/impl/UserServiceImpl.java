package cn.dhx.boot.service.impl;

import cn.dhx.boot.dao.UserDao;
import cn.dhx.boot.entity.User;
import cn.dhx.boot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-09-08 15:32:59
 */
@Service("userService")
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {


    @Override
//    @Transactional
    public void internalMethod() {
        insertB();
    }

    @Override
    public void internalMethod2() {
        UserServiceImpl o = (UserServiceImpl) AopContext.currentProxy();
        o.insertB();

//        insertB();
    }

    @Override
    @Transactional
    public void insertB() {
        User user = new User();
        user.setUserName("BB");
        this.baseMapper.insert(user);
        System.out.println(1 / 0);
    }


    @Override
    @Transactional
    public void insertA() {
        User user = new User();
        user.setUserName("AA");
        this.baseMapper.insert(user);
    }

//    @Override
//    @Transactional
//    public void insertB() {
//        User user = new User();
//        user.setUserName("BB");
//        this.baseMapper.insert(user);
//        System.out.println(1/0);
//    }


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertAREQUIRES_NEW() {
        User user = new User();
        user.setUserName("AA");
        this.baseMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertBREQUIRES_NEW() {
        User user = new User();
        user.setUserName("BB");
        this.baseMapper.insert(user);
        System.out.println(1 / 0);
    }


    @Transactional(rollbackFor = Exception.class) // 正常回滚
//    @Transactional // 不回滚
    public void transactionThrowsException() throws IOException {
        User user = new User();
        user.setUserName("transactionIOException");
        this.baseMapper.insert(user);
        throw new IOException();
    }


    @Transactional(rollbackFor = Exception.class)
    public void transactionTryCatchException() throws Exception {
        try {
            User user = new User();
            user.setUserName("transactionTryCatchException");
            this.baseMapper.insert(user);
            int i = 1 / 0;
        }catch (Exception e) {
            e.printStackTrace();
//            throw new Exception();  // 加上这一行  才能正常回滚
        }
    }

    @Override
    @Transactional(timeout = 3)
    public void transactionTimeout() {

        log.info("start");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setUserName("transactionTimeout");
        this.baseMapper.insert(user);
        log.info("end");

    }

    @Override
    @Transactional
    public void transactionThread() {
        new Thread(()->{
            User user = new User();
            user.setUserName("transactionThread");
            this.baseMapper.insert(user);
            System.out.println(1 / 0);
        }).start();
    }

    @Override
    public void test() {
        log.info("logback");
    }


}

