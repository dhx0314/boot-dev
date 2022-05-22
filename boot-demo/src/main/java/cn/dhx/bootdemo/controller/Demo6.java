package cn.dhx.bootdemo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class Demo6 {


    @CrossOrigin
    @GetMapping("/test")
    public String fun1(@RequestParam(required = false) String id) {
        log.info("test [{}]",id);
        return "ok";
    }
}
