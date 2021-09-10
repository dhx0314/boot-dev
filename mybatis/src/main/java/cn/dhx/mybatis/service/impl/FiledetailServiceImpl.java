package cn.dhx.mybatis.service.impl;

import cn.dhx.mybatis.entity.Filedetail;
import cn.dhx.mybatis.dao.FiledetailDao;
import cn.dhx.mybatis.service.FiledetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Filedetail)表服务实现类
 *
 * @author dhx
 * @since 2021-09-07 18:00:04
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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Filedetail> queryAllByLimit(int offset, int limit) {
        return this.filedetailDao.queryAllByLimit(offset, limit);
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
