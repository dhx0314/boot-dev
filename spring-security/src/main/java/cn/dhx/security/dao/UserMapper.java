package cn.dhx.security.dao;

import cn.dhx.security.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author daihongxin
 * @create 2023/7/11 11:15
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
}