package cn.dhx.mybatisplus.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.dhx.mybatisplus.entity.IpStation;
import org.apache.ibatis.annotations.Mapper;

/**
 * (IpStation)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-08 17:19:46
 */
@Mapper
@DS("slave_1")
public interface IpStationDao extends BaseMapper<IpStation> {

}
