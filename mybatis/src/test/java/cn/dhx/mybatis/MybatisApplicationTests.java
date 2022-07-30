package cn.dhx.mybatis;




import cn.dhx.mybatis.entity.Filedetail;
import cn.dhx.mybatis.service.impl.FiledetailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisApplicationTests {


    @Autowired
    private FiledetailServiceImpl filedetailService;

    @Test
    public void fun1() {
//        Filedetail byId = filedetailService.getById(140);
//        System.out.println(byId.toString());

        filedetailService.fun1();
    }


}
