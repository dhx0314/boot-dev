package cn.dhx.mybatisplus;


import cn.dhx.mybatisplus.dao.FiledetailDao;


import cn.dhx.mybatisplus.entity.Filedetail;
import cn.dhx.mybatisplus.entity.LeftDto2;
import cn.dhx.mybatisplus.service.impl.FiledetailServiceImpl;
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
    FiledetailServiceImpl filedetailService;

    @Autowired
    FiledetailDao filedetailDao;

    @Test
    public void ffun1() {

//        List<LeftDto> leftDtos = filedetailDao.selectAllLeft();
//
//        System.out.println(leftDtos);
//        Filedetail filedetail = new Filedetail();
//        filedetail.setAni("1234");
//        filedetail.setDnis("3789");
//        boolean save = filedetailService.save(filedetail);
//        System.out.println(save);
//
//        Filedetail byId = filedetailService.getById(10);
//        System.out.println(byId);

  //      LambdaQueryWrapperBuilder<Object> objectLambdaQueryWrapperBuilder = LambdaQueryWrapperBuilder.newBuilder();
    //    LambdaQueryWrapperBuilder<Filedetail> filedetailLambdaQueryWrapperBuilder = LambdaQueryWrapperBuilder.<Filedetail>newBuilder();


        List<LeftDto2> leftDao2s = filedetailDao.selectAllLeft2();
        System.out.println(leftDao2s);
        for (LeftDto2 leftDao2 : leftDao2s) {
            System.out.println(leftDao2);
        }

    }


//    public class GeneralMethod {
//        public static <U> void print(U[] list) {
//            System.out.println();
//            for (int i = 0; i < list.length; i++) {
//                System.out.print(" " + list[i]);
//            }
//            System.out.println();
//        }
//        public static void main(String[] args) {
//            String a[]={"a","b","c","d","e"};
//            Character b[]={'1','2','3','4','5'};
//            Integer c[]={1,2,3,4,5};
//            GeneralMethod.print(a);
//            GeneralMethod.print(b);
//            GeneralMethod.print(c);
//        }
//    }



}
