package com.wilcom.rqs.service.impl;

import com.wilcom.rqs.entity.StreamDetail;
import com.wilcom.rqs.dao.StreamDetailDao;
import com.wilcom.rqs.service.StreamDetailService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (StreamDetail)表服务实现类
 *
 * @author makejava
 * @since 2023-10-30 15:25:06
 */
@Service("streamDetailService")
public class StreamDetailServiceImpl implements StreamDetailService {
    @Resource
    private StreamDetailDao streamDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StreamDetail queryById(Long id) {
        return this.streamDetailDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param streamDetail 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<StreamDetail> queryByPage(StreamDetail streamDetail, PageRequest pageRequest) {
        long total = this.streamDetailDao.count(streamDetail);
        return new PageImpl<>(this.streamDetailDao.queryAllByLimit(streamDetail, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param streamDetail 实例对象
     * @return 实例对象
     */
    @Override
    public StreamDetail insert(StreamDetail streamDetail) {
        this.streamDetailDao.insert(streamDetail);
        return streamDetail;
    }

    /**
     * 修改数据
     *
     * @param streamDetail 实例对象
     * @return 实例对象
     */
    @Override
    public StreamDetail update(StreamDetail streamDetail) {
        this.streamDetailDao.update(streamDetail);
        return this.queryById(streamDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.streamDetailDao.deleteById(id) > 0;
    }
}
