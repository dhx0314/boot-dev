package cn.dhx.bootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lga/api/v1/config/")
@Slf4j
public class Demo6Controller {


    @PostMapping("fun")
    public String fun1() {

        return "fun1";
    }

    @PostMapping("sms")
    public String sms() {

        return "sms";
    }
}
