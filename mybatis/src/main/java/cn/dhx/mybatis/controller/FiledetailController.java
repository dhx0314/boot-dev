package cn.dhx.mybatis.controller;

import cn.dhx.mybatis.entity.Filedetail;
import cn.dhx.mybatis.service.FiledetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Filedetail)表控制层
 *
 * @author dhx
 * @since 2021-09-07 18:00:05
 */
@RestController
@RequestMapping("filedetail")
public class FiledetailController {
    /**
     * 服务对象
     */
    @Resource
    private FiledetailService filedetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Filedetail selectOne(Integer id) {
        return this.filedetailService.queryById(id);
    }

}
