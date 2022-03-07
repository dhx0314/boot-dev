package cn.dhx.bootdemo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class Demo5 {


    @GetMapping(value = "/callId",produces = "application/json")
    public void fun1(@RequestBody List<String> list) {
        log.info("-"+list.size());
        for (String s : list) {
            log.info("result "+s);
        }

    }
}

