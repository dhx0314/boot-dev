package cn.dhx.bootdemo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Demo6 {


    @CrossOrigin
    @GetMapping("/test0427")
    public String fun1() {
        log.info("test");
        return "ok";
    }
}
