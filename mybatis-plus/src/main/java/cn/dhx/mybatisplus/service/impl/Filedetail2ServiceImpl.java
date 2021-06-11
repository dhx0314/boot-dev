package cn.dhx.mybatisplus.service.impl;

import cn.dhx.mybatisplus.dao.Filedetail2Dao;
import cn.dhx.mybatisplus.entity.Filedetail2;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.dhx.mybatisplus.service.Filedetail2Service;
import org.springframework.stereotype.Service;

/**
 * (Filedetail)表服务实现类
 *
 * @author makejava
 * @since 2021-06-08 18:35:23
 */
@Service("filedetailService")
@DS("slave_1")
public class Filedetail2ServiceImpl extends ServiceImpl<Filedetail2Dao, Filedetail2> implements Filedetail2Service {

}
