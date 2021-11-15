package cn.dhx.mybatis;


import cn.dhx.mybatis.dao.FiledetailDao;
import cn.dhx.mybatis.entity.Filedetail;
import cn.dhx.mybatis.service.impl.FiledetailServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
class MybatisApplicationTests {

    @Autowired
    private FiledetailServiceImpl filedetailService;

    @Test
    public void fun1() {
        Filedetail byId = filedetailService.getById(1);
        System.out.println(byId.toString());
    }

}
