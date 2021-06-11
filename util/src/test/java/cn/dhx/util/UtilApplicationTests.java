package cn.dhx.util;

import cn.dhx.util.pool.TestObject;
import cn.dhx.util.pool.TestObjectPool;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class UtilApplicationTests {


    @Autowired
    private TestObjectPool testObjectPool;


    @Test
    public void test() {

        for (int i = 0; i < 20; i++) {

            new Thread(() -> {
                TestObject testObject = null;
                try {
                    testObject = testObjectPool.borrowObject();
                    //省略业务代码...
                    System.out.println(Thread.currentThread().getName()+"-----   "+testObject);
//                    System.out.println(testObject);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (testObject != null) {
                        //最终归还对象到对象池
                        testObjectPool.returnObject(testObject);
                    }
                }
            }).start();
        }
    }
}
