package cn.dhx.mybatis.service;

import cn.dhx.mybatis.entity.Filedetail;

import java.util.List;

/**
 * (Filedetail)表服务接口
 *
 * @author dhx
 * @since 2021-09-07 18:00:03
 */
public interface FiledetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Filedetail queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Filedetail> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param filedetail 实例对象
     * @return 实例对象
     */
    Filedetail insert(Filedetail filedetail);

    /**
     * 修改数据
     *
     * @param filedetail 实例对象
     * @return 实例对象
     */
    Filedetail update(Filedetail filedetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
