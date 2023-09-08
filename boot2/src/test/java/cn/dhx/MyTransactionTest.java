package cn.dhx;

import cn.dhx.boot.spring_transaction.MyTransaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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

    @Test
    public void testREQUIRED() {
        myTransaction.testREQUIRED();
    }


    @Test
    public void testREQUIRES_NEW() {
        myTransaction.testREQUIRES_NEW();
    }


}
