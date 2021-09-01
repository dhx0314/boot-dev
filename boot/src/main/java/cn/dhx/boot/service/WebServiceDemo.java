package cn.dhx.boot.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@Slf4j
public class WebServiceDemo {


    @Autowired
    private MyServiceUtil myServiceUtil;

    @Value("${aa.bb}")
    private String demo;

    @PostConstruct
    public void fun1aa() {
        log.info("------@PostConstruct---------------");
        log.info(demo);
        myServiceUtil.fun1("abc");
        MyServiceUtil.send();
    }

    @GetMapping("/hia")
    public String fun1() {


        MyServiceUtil.send();
        return "11";
    }
}
