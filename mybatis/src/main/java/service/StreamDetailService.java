package com.wilcom.rcs.service;

import com.wilcom.rcs.entity.StreamDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (StreamDetail)表服务接口
 *
 * @author makejava
 * @since 2023-10-27 15:10:14
 */
public interface StreamDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StreamDetail queryById(Long id);

    /**
     * 分页查询
     *
     * @param streamDetail 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<StreamDetail> queryByPage(StreamDetail streamDetail, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param streamDetail 实例对象
     * @return 实例对象
     */
    StreamDetail insert(StreamDetail streamDetail);

    /**
     * 修改数据
     *
     * @param streamDetail 实例对象
     * @return 实例对象
     */
    StreamDetail update(StreamDetail streamDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
