package cn.dhx.mybatis;


import cn.dhx.mybatis.dao.FiledetailDao;
import cn.dhx.mybatis.entity.Filedetail;
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
    FiledetailDao filedetailDao;



    @Test
    void contextLoads() {
        Filedetail filedetail = filedetailDao.queryById(1);
        System.out.println(filedetail.toString());

        List<Map<String,Object>> maps = filedetailDao.queryById2(1);
        System.out.println(maps);
    }

}
