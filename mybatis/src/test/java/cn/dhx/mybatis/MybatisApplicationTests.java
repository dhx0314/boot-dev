package cn.dhx.mybatis;



import cn.dhx.mybatis.dao.MyTestDao;
import cn.dhx.mybatis.entity.MyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisApplicationTests {



    @Autowired
    MyTestDao testDao;

    @Test
    public void fun1() {
        MyTest myTest = testDao.queryById(1);
        System.out.println(myTest);
        MyTest myTest2 = testDao.queryById(2);
        System.out.println(myTest2);
    }

}
