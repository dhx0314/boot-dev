package cn.dhx.boot.controller;


import cn.dhx.boot.aop.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author daihongxin
 * @create 2023/3/8 15:27
 */

@RestController
@Slf4j
@Log
public class DemoController {


    @Autowired
    private RestTemplate restTemplate;

    @Log
    @GetMapping("hi")
    public Object hi() {
        log.info("aa");
        return "aa";
    }


}
