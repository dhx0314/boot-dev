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
}
