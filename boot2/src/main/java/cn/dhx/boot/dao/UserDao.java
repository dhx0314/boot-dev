package cn.dhx.boot.dao;

import cn.dhx.boot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-08 15:32:30
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}

