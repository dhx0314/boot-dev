package cn.dhx.mybatis.service;

import cn.dhx.mybatis.entity.Filedetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Filedetail)表服务接口
 *
 * @author dhx
 * @since 2021-12-16 15:06:12
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
     * 分页查询
     *
     * @param filedetail 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Filedetail> queryByPage(Filedetail filedetail, PageRequest pageRequest);

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
