package cn.dhx.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('test')")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/hello/del")
    @PreAuthorize("hasAuthority('test.del')")
    public String helloDel(){
        return "helloDel";
    }
}
