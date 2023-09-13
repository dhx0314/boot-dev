package cn.dhx.boot.controller;


import cn.dhx.boot.aop.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/3/8 15:27
 */

@RestController
@Slf4j
@Log
public class DemoController {



    @Log
    @GetMapping("hi")
    public Object hi() {
        log.info("aa");
        return "aa";
    }


    @Log
    @GetMapping("hello")
    public Object hello() {
        log.info("hello");
        return "aa";
    }

    @PostMapping("test")
    public Object timeout(@RequestBody String data)  {
        log.info("timeout {}",data);
        return "ok";
    }





}
