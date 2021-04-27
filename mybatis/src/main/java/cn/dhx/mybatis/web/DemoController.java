package cn.dhx.mybatis.web;


import cn.dhx.mybatis.config.GlobalConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @GetMapping("hi")
    public String test(@RequestBody String data, @RequestParam("aa") String a1) {
        System.out.println(a1);
        System.out.println(data);
        return "hi";
    }

    @GetMapping("/hello2")
    public String a1() {
        System.out.println(GlobalConfig.SESSION_TIMEOUT);
        return "wae";
    }


}
