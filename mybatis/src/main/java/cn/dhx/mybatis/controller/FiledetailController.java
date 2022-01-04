package cn.dhx.mybatis.controller;

import cn.dhx.mybatis.entity.Filedetail;
import cn.dhx.mybatis.service.FiledetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Filedetail)表控制层
 *
 * @author dhx
 * @since 2021-12-16 15:06:09
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
     * 分页查询
     *
     * @param filedetail 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Filedetail>> queryByPage(Filedetail filedetail, PageRequest pageRequest) {
        return ResponseEntity.ok(this.filedetailService.queryByPage(filedetail, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Filedetail> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.filedetailService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param filedetail 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Filedetail> add(Filedetail filedetail) {
        return ResponseEntity.ok(this.filedetailService.insert(filedetail));
    }

    /**
     * 编辑数据
     *
     * @param filedetail 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Filedetail> edit(Filedetail filedetail) {
        return ResponseEntity.ok(this.filedetailService.update(filedetail));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.filedetailService.deleteById(id));
    }

}

