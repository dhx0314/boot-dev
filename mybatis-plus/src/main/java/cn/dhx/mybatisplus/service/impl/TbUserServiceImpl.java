package cn.dhx.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.dhx.mybatisplus.dao.TbUserDao;
import cn.dhx.mybatisplus.entity.TbUser;
import cn.dhx.mybatisplus.service.TbUserService;
import org.springframework.stereotype.Service;

/**
 * (TbUser)表服务实现类
 *
 * @author dhx
 * @since 2021-06-08 01:03:13
 */
@Service("tbUserService")
public class TbUserServiceImpl extends ServiceImpl<TbUserDao, TbUser> implements TbUserService {

}
