package cn.com.wilcom.repository.dao;

import cn.com.wilcom.repository.entity.TSkillDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TSkillDetail)表数据库访问层
 *
 * @author dhx
 * @since 2022-07-20 11:28:36
 */
public interface TSkillDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TSkillDetail queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tSkillDetail 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TSkillDetail> queryAllByLimit(TSkillDetail tSkillDetail, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tSkillDetail 查询条件
     * @return 总行数
     */
    long count(TSkillDetail tSkillDetail);

    /**
     * 新增数据
     *
     * @param tSkillDetail 实例对象
     * @return 影响行数
     */
    int insert(TSkillDetail tSkillDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TSkillDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TSkillDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TSkillDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TSkillDetail> entities);

    /**
     * 修改数据
     *
     * @param tSkillDetail 实例对象
     * @return 影响行数
     */
    int update(TSkillDetail tSkillDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

