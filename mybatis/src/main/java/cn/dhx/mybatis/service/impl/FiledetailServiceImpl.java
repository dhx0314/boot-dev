package cn.dhx.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.dhx.mybatis.dao.FiledetailDao;
import cn.dhx.mybatis.entity.Filedetail;
import cn.dhx.mybatis.service.FiledetailService;
import org.springframework.stereotype.Service;

/**
 * (Filedetail)表服务实现类
 *
 * @author dhx
 * @since 2022-07-05 09:45:27
 */
@Service("filedetailService")
public class FiledetailServiceImpl extends ServiceImpl<FiledetailDao, Filedetail> implements FiledetailService {

}

