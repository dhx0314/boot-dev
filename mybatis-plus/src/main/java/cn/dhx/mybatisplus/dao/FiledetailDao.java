package cn.dhx.mybatisplus.dao;

import cn.dhx.mybatisplus.entity.LeftDto;
import cn.dhx.mybatisplus.entity.LeftDto2;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.dhx.mybatisplus.entity.Filedetail;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Filedetail)表数据库访问层
 *
 * @author dhx
 * @since 2022-07-05 09:50:02
 */
public interface FiledetailDao extends BaseMapper<Filedetail> {


    @Select("select f.*,r.httpdURL,r.pathname  from filedetail f left join recpathmap r  on f.id=r.id  WHERE r.id  is not null ")
    List<LeftDto> selectAllLeft();


    @Select("select f.*,mt .* from filedetail f  left join my_test mt    on f.id =mt.info  limit 10")
    List<LeftDto2> selectAllLeft2();
}

