package cn.dhx.mybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.dhx.mybatis.entity.Filedetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * (Filedetail)表数据库访问层
 *
 * @author dhx
 * @since 2021-11-10 16:00:38
 */
@Mapper
public interface FiledetailDao extends BaseMapper<Filedetail> {

}
