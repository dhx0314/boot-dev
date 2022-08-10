package cn.dhx.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.dhx.mybatisplus.dao.TSkillDetailDao;
import cn.dhx.mybatisplus.entity.TSkillDetail;
import cn.dhx.mybatisplus.service.TSkillDetailService;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (TSkillDetail)表服务实现类
 *
 * @author dhx
 * @since 2022-07-16 14:08:17
 */
@Service("tSkillDetailService")
public class TSkillDetailServiceImpl extends ServiceImpl<TSkillDetailDao, TSkillDetail> implements TSkillDetailService {


    public void fun1() {
        List<TSkillDetail> list = new LambdaQueryChainWrapper<>(this.baseMapper).eq(TSkillDetail::getId, 13).list();

        System.out.println(list.size());
        saveBatch(list);
//        updateBatchById()
    }
}

