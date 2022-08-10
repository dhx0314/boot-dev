package cn.com.wilcom.repository.dao;

import cn.com.wilcom.repository.entity.TAgentStateDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TAgentStateDetail)表数据库访问层
 *
 * @author dhx
 * @since 2022-07-20 10:41:07
 */
public interface TAgentStateDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TAgentStateDetail queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tAgentStateDetail 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TAgentStateDetail> queryAllByLimit(TAgentStateDetail tAgentStateDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tAgentStateDetail 查询条件
     * @return 总行数
     */
    long count(TAgentStateDetail tAgentStateDetail);

    /**
     * 新增数据
     *
     * @param tAgentStateDetail 实例对象
     * @return 影响行数
     */
    int insert(TAgentStateDetail tAgentStateDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAgentStateDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TAgentStateDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAgentStateDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TAgentStateDetail> entities);

    /**
     * 修改数据
     *
     * @param tAgentStateDetail 实例对象
     * @return 影响行数
     */
    int update(TAgentStateDetail tAgentStateDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

