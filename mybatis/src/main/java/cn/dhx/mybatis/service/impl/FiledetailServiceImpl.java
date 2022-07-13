package cn.dhx.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.dhx.mybatis.dao.FiledetailDao;
import cn.dhx.mybatis.entity.Filedetail;
import cn.dhx.mybatis.service.FiledetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (Filedetail)表服务实现类
 *
 * @author dhx
 * @since 2022-07-13 23:05:51
 */
@Service("filedetailService")
public class FiledetailServiceImpl extends ServiceImpl<FiledetailDao, Filedetail> implements FiledetailService {


    @Transactional
    public void fun1() {
        Filedetail filedetail = new Filedetail();
        filedetail.setAni("1234");
        this.baseMapper.insert(filedetail);
    }
}

