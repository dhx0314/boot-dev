package cn.dhx.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.dhx.mybatisplus.entity.TbUser;
import cn.dhx.mybatisplus.service.TbUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TbUser)表控制层
 *
 * @author dhx
 * @since 2021-06-08 01:03:13
 */
@RestController
@RequestMapping("tbUser")
public class TbUserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TbUserService tbUserService;

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param tbUser 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TbUser> page, TbUser tbUser) {
        return success(this.tbUserService.page(page, new QueryWrapper<>(tbUser)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tbUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tbUser 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TbUser tbUser) {
        return success(this.tbUserService.save(tbUser));
    }

    /**
     * 修改数据
     *
     * @param tbUser 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TbUser tbUser) {
        return success(this.tbUserService.updateById(tbUser));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tbUserService.removeByIds(idList));
    }
}
