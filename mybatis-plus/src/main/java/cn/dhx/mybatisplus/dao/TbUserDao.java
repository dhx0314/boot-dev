package cn.dhx.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.dhx.mybatisplus.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * (TbUser)表数据库访问层
 *
 * @author dhx
 * @since 2021-06-08 01:03:12
 */

@Mapper
public interface TbUserDao extends BaseMapper<TbUser> {

}
