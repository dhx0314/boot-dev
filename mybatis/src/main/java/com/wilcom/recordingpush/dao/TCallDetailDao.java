package com.wilcom.recordingpush.dao;

import com.wilcom.recordingpush.entity.TCallDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TCallDetail)表数据库访问层
 *
 * @author dhx
 * @since 2022-03-31 10:29:21
 */
public interface TCallDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TCallDetail queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tCallDetail 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TCallDetail> queryAllByLimit(TCallDetail tCallDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tCallDetail 查询条件
     * @return 总行数
     */
    long count(TCallDetail tCallDetail);

    /**
     * 新增数据
     *
     * @param tCallDetail 实例对象
     * @return 影响行数
     */
    int insert(TCallDetail tCallDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCallDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TCallDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCallDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TCallDetail> entities);

    /**
     * 修改数据
     *
     * @param tCallDetail 实例对象
     * @return 影响行数
     */
    int update(TCallDetail tCallDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}
