package cn.dhx.boot.spring_transaction;

import cn.dhx.boot.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author daihongxin
 * @create 2023/9/4 15:47
 */
@Slf4j
@Component
public class MyTransaction {


    @Autowired
    private UserServiceImpl userService;



    @Transactional(propagation = Propagation.REQUIRED)
    public void testREQUIRED() {
        // A B 插入都失败
        userService.insertA();
        userService.insertB();
    }



    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testREQUIRES_NEW() {
        // A 插入成功
        // B 插入失败
        userService.insertA();
        userService.insertB();
    }




    public void internalMethodTest() {
        userService.internalMethod();
    }
}
