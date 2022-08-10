package cn.dhx.mybatisplus;



import cn.dhx.mybatisplus.dao.TSkillDetailDao;
import cn.dhx.mybatisplus.entity.TSkillDetail;
import cn.dhx.mybatisplus.service.impl.TSkillDetailServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
class MybatisPlusApplicationTests {



    @Autowired
    private TSkillDetailDao tSkillDetailDao;

    @Autowired
    private TSkillDetailServiceImpl tSkillDetailService;

    @Test
    public void fun1() {
//        TSkillDetail byId = tSkillDetailService.getById(1);
//        System.out.println(byId);

        tSkillDetailService.fun1();
        TSkillDetail tSkillDetail = tSkillDetailDao.selectById(13);
        System.out.println(tSkillDetail);
    }




}
