package cn.dhx.mybatisplus;

import cn.dhx.mybatisplus.dao.IpStationDao;
import cn.dhx.mybatisplus.dao.TbUserDao;
import cn.dhx.mybatisplus.entity.Filedetail;
import cn.dhx.mybatisplus.entity.IpStation;
import cn.dhx.mybatisplus.entity.TbUser;
import cn.dhx.mybatisplus.service.FiledetailService;
import cn.dhx.mybatisplus.service.IpStationService;
import cn.dhx.mybatisplus.service.TbUserService;
import cn.dhx.mybatisplus.service.impl.TbUserServiceImpl;
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
    private TbUserService tbUserService;

    @Autowired
    private IpStationService ipStationService;

//    @Autowired
//    private IpStationService2 ipStationService2;


    @Autowired
    private FiledetailService filedetailService;


    @Autowired
    private IpStationDao ipStationDao;

    @Autowired
    private TbUserDao tbUserDao;

    @Test
    public void fu1() {
        int count = tbUserService.count();
        System.out.println(count);
        int count1 = ipStationService.count();
        System.out.println(count1+"   1");


        IpStation ipStation = new IpStation();
        ipStation.setStation("1005");
        ipStationService.save(ipStation);

        List<IpStation> list = ipStationService.list();
        for (IpStation ipStation2 : list) {
            System.out.println(ipStation2);
        }
    }

    @Test
    public void fun1() {


//        List<Filedetail> list = filedetailService.list();
//        for (Filedetail filedetail : list) {
//            System.out.println(filedetail);
//        }
//        System.out.println(list.size());
//
//        int count = filedetailService.count();
//        System.out.println(count);
        QueryWrapper<Filedetail> wrapper = new QueryWrapper<>();
        String s="2021-03-30 17:20:00";
        wrapper.apply("to_char(STARTDATETIME,'yyyy-MM-dd HH24:MI:SS')<={0}",s);
//        wrapper.apply("id=60");
        List<Filedetail> list1 = filedetailService.list(wrapper);
        System.out.println(list1.size());
//        for (Filedetail filedetail : list1) {
//            System.out.println(filedetail);
//        }
    }


    @Test
    public void funaa1() {
        int count = filedetailService.count();
        System.out.println(count);
    }


    @Test
    public void fu1qq() {

        int count1 = ipStationService.count();
        System.out.println(count1+"   1");


        IpStation ipStation = new IpStation();
        ipStation.setStation("1005");
        ipStationService.save(ipStation);

        int count21 = ipStationService.count();
        System.out.println(count21+"   2");
    }

    @Test
    public void fun2b() {

        QueryWrapper<TbUser> tbUserQueryWrapper = new QueryWrapper<>();
        tbUserQueryWrapper
                .eq(true,"user_name","lisi")
                .eq(false,"age","22");
        List<TbUser> list = tbUserService.list(tbUserQueryWrapper);
        for (TbUser tbUser : list) {
            System.out.println(tbUser);
        }
    }

    @Test
    public void fun2c() {
//        LambdaQueryWrapper<TbUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.ge("age",21);

//        LambdaQueryWrapper<TbUser> userLambdaQueryWrapper = Wrappers.lambdaQuery();
//        userLambdaQueryWrapper.like(TbUser::getAge , "k");
        QueryWrapper<TbUser> tbUserQueryWrapper = new QueryWrapper<>();
        tbUserQueryWrapper
                .lambda()
                .eq(TbUser::getAge,"20");
        Page<TbUser> userIPage = tbUserDao.selectPage(new Page<TbUser>(1, 2), tbUserQueryWrapper);

        System.out.println("Current:"+userIPage.getCurrent());
        System.out.println("Total:"+userIPage.getTotal());
        System.out.println("Pages:"+userIPage.getPages());
        System.out.println("Size:"+userIPage.getSize());
        List<TbUser> records = userIPage.getRecords();
        for (TbUser record : records) {
            System.out.println(record);
        }
    }





}
