package cn.dhx.bootdemo.dao;

import cn.dhx.bootdemo.entity.MyDetial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (MyDetial)表数据库访问层
 *
 * @author dhx
 * @since 2022-06-21 17:15:28
 */
@Mapper
public interface MyDetialDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MyDetial queryById(Integer id);

    List<MyDetial> queryAll();

    /**
     * 查询指定行数据
     *
     * @param myDetial 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<MyDetial> queryAllByLimit(MyDetial myDetial, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param myDetial 查询条件
     * @return 总行数
     */
    long count(MyDetial myDetial);

    /**
     * 新增数据
     *
     * @param myDetial 实例对象
     * @return 影响行数
     */
    int insert(MyDetial myDetial);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MyDetial> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MyDetial> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MyDetial> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MyDetial> entities);

    /**
     * 修改数据
     *
     * @param myDetial 实例对象
     * @return 影响行数
     */
    int update(MyDetial myDetial);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

