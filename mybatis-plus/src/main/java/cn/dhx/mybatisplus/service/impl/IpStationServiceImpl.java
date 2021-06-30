package cn.dhx.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.dhx.mybatisplus.dao.IpStationDao;
import cn.dhx.mybatisplus.entity.IpStation;
import cn.dhx.mybatisplus.service.IpStationService;
import org.springframework.stereotype.Service;

/**
 * (IpStation)表服务实现类
 *
 * @author makejava
 * @since 2021-06-08 17:19:46
 */
@Service
//@DS("slave_1")
public class IpStationServiceImpl extends ServiceImpl<IpStationDao, IpStation> implements IpStationService {

}
