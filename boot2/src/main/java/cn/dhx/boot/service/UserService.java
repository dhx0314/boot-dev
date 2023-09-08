package cn.dhx.boot.service;

import cn.dhx.boot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2023-09-08 15:32:59
 */
public interface UserService extends IService<User> {


    void insertA();

    void insertB();


    void insertAREQUIRES_NEW();

    void insertBREQUIRES_NEW();
}

