package cn.dhx.boot.dao;

import cn.dhx.boot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-08 15:32:30
 */
@Mapper
public interface UserDao extends BaseMapper<User> {


    @Select("select * from t_user")
    List<User> queryAll2();

}

