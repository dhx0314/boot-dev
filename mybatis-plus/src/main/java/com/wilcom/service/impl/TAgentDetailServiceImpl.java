package com.wilcom.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wilcom.dao.TAgentDetailDao;
import com.wilcom.entity.TAgentDetail;
import com.wilcom.service.TAgentDetailService;
import org.springframework.stereotype.Service;

/**
 * (TAgentDetail)表服务实现类
 *
 * @author dhx
 * @since 2022-08-09 12:15:10
 */
@Service("tAgentDetailService")
public class TAgentDetailServiceImpl extends ServiceImpl<TAgentDetailDao, TAgentDetail> implements TAgentDetailService {

}

