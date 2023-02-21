package cn.dhx.bootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Demo6Controller {


    @PostMapping(value = "/test",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public String fun1() {

        return "fun1";
    }

    @PostMapping("sms")
    public String sms() {

        return "sms";
    }
}
