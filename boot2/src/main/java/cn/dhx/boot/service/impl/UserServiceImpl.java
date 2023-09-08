package cn.dhx.boot.service.impl;

import cn.dhx.boot.entity.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.dhx.boot.dao.UserDao;
import cn.dhx.boot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-09-08 15:32:59
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    @Transactional
    public void insertA() {
        User user = new User();
        user.setUserName("AA");
        this.baseMapper.insert(user);
    }

    @Override
    @Transactional
    public void insertB() {
        User user = new User();
        user.setUserName("BB");
        this.baseMapper.insert(user);
        System.out.println(1/0);
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertAREQUIRES_NEW() {
        User user = new User();
        user.setUserName("AA");
        this.baseMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertBREQUIRES_NEW() {
        User user = new User();
        user.setUserName("BB");
        this.baseMapper.insert(user);
        System.out.println(1/0);
    }


}

