package cn.com.wilcom.repository.dao;

import cn.com.wilcom.repository.entity.TAgentSessionDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TAgentSessionDetail)表数据库访问层
 *
 * @author dhx
 * @since 2022-07-20 14:42:44
 */
public interface TAgentSessionDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TAgentSessionDetail queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tAgentSessionDetail 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TAgentSessionDetail> queryAllByLimit(TAgentSessionDetail tAgentSessionDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tAgentSessionDetail 查询条件
     * @return 总行数
     */
    long count(TAgentSessionDetail tAgentSessionDetail);

    /**
     * 新增数据
     *
     * @param tAgentSessionDetail 实例对象
     * @return 影响行数
     */
    int insert(TAgentSessionDetail tAgentSessionDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAgentSessionDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TAgentSessionDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TAgentSessionDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TAgentSessionDetail> entities);

    /**
     * 修改数据
     *
     * @param tAgentSessionDetail 实例对象
     * @return 影响行数
     */
    int update(TAgentSessionDetail tAgentSessionDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

