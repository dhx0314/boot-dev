package cn.dhx.mybatisplus;

import cn.dhx.mybatisplus.dao.IpStationDao;
import cn.dhx.mybatisplus.entity.Filedetail2;
import cn.dhx.mybatisplus.entity.IpStation;
import cn.dhx.mybatisplus.service.Filedetail2Service;
import cn.dhx.mybatisplus.service.IpStationService;
import cn.dhx.mybatisplus.service.TbUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    private Filedetail2Service filedetail2Service;


    @Autowired
    private IpStationDao ipStationDao;

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


//        List<Filedetail> list = filedetail2Service.list();
//        for (Filedetail filedetail : list) {
//            System.out.println(filedetail);
//        }
//        System.out.println(list.size());
//
//        int count = filedetail2Service.count();
//        System.out.println(count);
        int count = filedetail2Service.count();
        System.out.println(count);
        QueryWrapper<Filedetail2> wrapper = new QueryWrapper<>();
        String s="2021-03-30 17:20:00";
        wrapper.apply("to_char(STARTDATETIME,'yyyy-MM-dd HH24:MI:SS')<={0}",s);
//        wrapper.apply("id=60");
        List<Filedetail2> list1 = filedetail2Service.list(wrapper);
        System.out.println(list1.size());
//        for (Filedetail filedetail : list1) {
//            System.out.println(filedetail);
//        }
    }


    @Test
    public void funaa1() {
        int count = filedetail2Service.count();
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

}
