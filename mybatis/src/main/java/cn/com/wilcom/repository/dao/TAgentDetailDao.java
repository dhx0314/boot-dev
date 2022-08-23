package cn.com.wilcom.repository.dao;

import cn.com.wilcom.repository.entity.TAgentDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TAgentDetail)表数据库访问层
 *
 * @author dhx
 * @since 2022-07-20 10:36:47
 */
public interface TAgentDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TAgentDetail queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tAgentDetail 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TAgentDetail> queryAllByLimit(TAgentDetail tAgentDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tAgentDetail 查询条件
     * @return 总行数
     */
    long count(TAgentDetail tAgentDetail);

    /**
     * 新增数据
     *
     * @param tAgentDetail 实例对象
     * @return 影响行数
     */
    int insert(TAgentDetail tAgentDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAgentDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TAgentDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAgentDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TAgentDetail> entities);

    /**
     * 修改数据
     *
     * @param tAgentDetail 实例对象
     * @return 影响行数
     */
    int update(TAgentDetail tAgentDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
