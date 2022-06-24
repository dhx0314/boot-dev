package cn.dhx.bootdemo.dao;

import cn.dhx.bootdemo.entity.Filedetail;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/**
 * (Filedetail)表数据库访问层
 *
 * @author dhx
 * @since 2022-06-21 10:00:41
 */
@Mapper
public interface FiledetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Filedetail queryById(String id);

    List<Filedetail> queryAll();

    /**
     * 查询指定行数据
     *
     * @param filedetail 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Filedetail> queryAllByLimit(Filedetail filedetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param filedetail 查询条件
     * @return 总行数
     */
    long count(Filedetail filedetail);

    /**
     * 新增数据
     *
     * @param filedetail 实例对象
     * @return 影响行数
     */
    int insert(Filedetail filedetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Filedetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Filedetail> entities);


    int insertOrUpdateBatch(@Param("entities") List<Filedetail> entities);

    /**
     * 修改数据
     *
     * @param filedetail 实例对象
     * @return 影响行数
     */
    int update(Filedetail filedetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

