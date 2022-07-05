package cn.dhx.mybatisplus;


import cn.dhx.mybatisplus.entity.Filedetail;


import cn.dhx.mybatisplus.service.impl.FiledetailServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
class MybatisPlusApplicationTests {


    @Autowired
    FiledetailServiceImpl filedetailService;

    @Test
    public void ffun1() {
        Filedetail filedetail = new Filedetail();
        filedetail.setAni("1234");
        filedetail.setDnis("3789");
        boolean save = filedetailService.save(filedetail);
        System.out.println(save);
    }

}
