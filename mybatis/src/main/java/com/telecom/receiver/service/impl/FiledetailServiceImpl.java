package com.telecom.receiver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.telecom.receiver.dao.FiledetailDao;
import com.telecom.receiver.entity.Filedetail;
import com.telecom.receiver.service.FiledetailService;
import org.springframework.stereotype.Service;

/**
 * (Filedetail)表服务实现类
 *
 * @author makejava
 * @since 2023-06-01 14:55:57
 */
@Service("filedetailService")
public class FiledetailServiceImpl extends ServiceImpl<FiledetailDao, Filedetail> implements FiledetailService {

}

