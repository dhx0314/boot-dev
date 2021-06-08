package cn.dhx.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.dhx.mybatisplus.dao.TbUserDao;
import cn.dhx.mybatisplus.entity.TbUser;
import cn.dhx.mybatisplus.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (TbUser)表服务实现类
 *
 * @author dhx
 * @since 2021-06-08 01:03:13
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserDao, TbUser> implements TbUserService {


    @Autowired
    private TbUserDao tbUserDao;

    public void fun2c() {
//        LambdaQueryWrapper<TbUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.ge("age",21);

//        LambdaQueryWrapper<TbUser> userLambdaQueryWrapper = Wrappers.lambdaQuery();
//        userLambdaQueryWrapper.like(TbUser::getAge , "k");
        QueryWrapper<TbUser> tbUserQueryWrapper = new QueryWrapper<>();
        tbUserQueryWrapper
                .lambda()
                .ge(TbUser::getAge,"20");


        LambdaQueryWrapper<TbUser> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(TbUser::getAge ,1);
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
