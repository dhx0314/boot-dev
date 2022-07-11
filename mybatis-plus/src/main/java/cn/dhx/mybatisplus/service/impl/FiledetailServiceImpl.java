package cn.dhx.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.dhx.mybatisplus.dao.FiledetailDao;
import cn.dhx.mybatisplus.entity.Filedetail;
import cn.dhx.mybatisplus.service.FiledetailService;
import org.junit.Test;
import org.springframework.stereotype.Service;

/**
 * (Filedetail)表服务实现类
 *
 * @author dhx
 * @since 2022-07-05 09:50:05
 */
@Service("filedetailService")
//@DS("slave_1")
public class FiledetailServiceImpl extends ServiceImpl<FiledetailDao, Filedetail> implements FiledetailService {



}

