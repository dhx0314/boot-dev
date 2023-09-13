package cn.dhx;

import cn.dhx.boot.service.UserService;
import cn.dhx.boot.service.impl.MyServiceSon;
import cn.dhx.boot.spring_transaction.MyTransaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/9/8 15:56
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTransactionTest {



    @Autowired
    private MyTransaction myTransaction;

    @Autowired
    private MyServiceSon myServiceSon;

    @Autowired
    private UserService userService;

    @Test
    public void testREQUIRED() {
        myTransaction.testREQUIRED();
    }


    @Test
    public void testREQUIRES_NEW() {
        myTransaction.testREQUIRES_NEW();
    }


    @Test
    public void internalMethodTest() {
        myTransaction.internalMethodTest();
    }


    @Test
    public void sonMethod() {
        myServiceSon.doSomething("11");
    }

    @Test
    public void transactionIOExceptionTest() {
        try {
            userService.transactionThrowsException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void transactionTryCatchException() {
        try {
            userService.transactionTryCatchException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void transactionTimeout() {
        userService.transactionTimeout();
    }

    @Test
    public void transactionThread() {
        userService.transactionThread();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
