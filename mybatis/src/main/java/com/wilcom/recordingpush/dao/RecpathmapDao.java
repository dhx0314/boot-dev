package com.wilcom.recordingpush.dao;

import com.wilcom.recordingpush.entity.Recpathmap;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Recpathmap)表数据库访问层
 *
 * @author dhx
 * @since 2022-03-31 13:10:36
 */
public interface RecpathmapDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Recpathmap queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param recpathmap 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Recpathmap> queryAllByLimit(Recpathmap recpathmap, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param recpathmap 查询条件
     * @return 总行数
     */
    long count(Recpathmap recpathmap);

    /**
     * 新增数据
     *
     * @param recpathmap 实例对象
     * @return 影响行数
     */
    int insert(Recpathmap recpathmap);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Recpathmap> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Recpathmap> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Recpathmap> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Recpathmap> entities);

    /**
     * 修改数据
     *
     * @param recpathmap 实例对象
     * @return 影响行数
     */
    int update(Recpathmap recpathmap);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

