package cn.dhx.mybatis.dao;

import cn.dhx.mybatis.entity.MyTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (MyTest)表数据库访问层
 *
 * @author dhx
 * @since 2022-06-29 14:13:08
 */

@Mapper
public interface MyTestDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MyTest queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param myTest 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<MyTest> queryAllByLimit(MyTest myTest, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param myTest 查询条件
     * @return 总行数
     */
    long count(MyTest myTest);

    /**
     * 新增数据
     *
     * @param myTest 实例对象
     * @return 影响行数
     */
    int insert(MyTest myTest);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MyTest> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MyTest> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MyTest> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<MyTest> entities);

    /**
     * 修改数据
     *
     * @param myTest 实例对象
     * @return 影响行数
     */
    int update(MyTest myTest);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

