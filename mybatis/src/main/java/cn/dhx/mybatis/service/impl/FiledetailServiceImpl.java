package cn.dhx.mybatis.service.impl;

import cn.dhx.mybatis.entity.Filedetail;
import cn.dhx.mybatis.dao.FiledetailDao;
import cn.dhx.mybatis.service.FiledetailService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Filedetail)表服务实现类
 *
 * @author dhx
 * @since 2021-12-16 15:06:13
 */
@Service("filedetailService")
public class FiledetailServiceImpl implements FiledetailService {
    @Resource
    private FiledetailDao filedetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Filedetail queryById(Integer id) {
        return this.filedetailDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param filedetail 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Filedetail> queryByPage(Filedetail filedetail, PageRequest pageRequest) {
        long total = this.filedetailDao.count(filedetail);
        return new PageImpl<>(this.filedetailDao.queryAllByLimit(filedetail, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param filedetail 实例对象
     * @return 实例对象
     */
    @Override
    public Filedetail insert(Filedetail filedetail) {
        this.filedetailDao.insert(filedetail);
        return filedetail;
    }

    /**
     * 修改数据
     *
     * @param filedetail 实例对象
     * @return 实例对象
     */
    @Override
    public Filedetail update(Filedetail filedetail) {
        this.filedetailDao.update(filedetail);
        return this.queryById(filedetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.filedetailDao.deleteById(id) > 0;
    }
}
