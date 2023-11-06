package com.wilcom.rqs.dao;

import com.wilcom.rqs.entity.StreamDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (StreamDetail)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-30 15:25:04
 */
public interface StreamDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StreamDetail queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param streamDetail 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<StreamDetail> queryAllByLimit(StreamDetail streamDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param streamDetail 查询条件
     * @return 总行数
     */
    long count(StreamDetail streamDetail);

    /**
     * 新增数据
     *
     * @param streamDetail 实例对象
     * @return 影响行数
     */
    int insert(StreamDetail streamDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<StreamDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<StreamDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<StreamDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<StreamDetail> entities);

    /**
     * 修改数据
     *
     * @param streamDetail 实例对象
     * @return 影响行数
     */
    int update(StreamDetail streamDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

