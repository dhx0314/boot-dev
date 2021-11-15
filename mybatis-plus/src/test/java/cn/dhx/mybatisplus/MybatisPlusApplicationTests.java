package cn.dhx.mybatisplus;


import cn.dhx.mybatisplus.entity.Filedetail2;

import cn.dhx.mybatisplus.service.impl.Filedetail2ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    Filedetail2ServiceImpl filedetail2Service;

    @Test
    public void ffun1() {
        Filedetail2 byId = filedetail2Service.getById(1);
        System.out.println(byId);
    }

}
