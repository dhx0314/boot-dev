package cn.dhx.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author daihongxin
 * @create 2023/7/11 9:52
 */
@Slf4j
@RestController
public class HelloController {


    @GetMapping("hi")
    public String hi() {
        return "ok";
    }
}
