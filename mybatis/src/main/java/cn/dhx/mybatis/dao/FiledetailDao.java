package cn.dhx.mybatis.dao;

import cn.dhx.mybatis.entity.Filedetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.ManagedBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Filedetail)表数据库访问层
 *
 * @author dhx
 * @since 2021-09-07 18:00:02
 */
@Mapper
public interface FiledetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Filedetail queryById(Integer id);

//    List<Map<String,Object>>

    List<Map<String,Object>> queryById2(Integer id);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Filedetail> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param filedetail 实例对象
     * @return 对象列表
     */
    List<Filedetail> queryAll(Filedetail filedetail);

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

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Filedetail> 实例对象列表
     * @return 影响行数
     */
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
    int deleteById(Integer id);

}

