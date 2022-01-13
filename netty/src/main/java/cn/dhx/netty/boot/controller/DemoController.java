package cn.dhx.netty.boot.controller;


import cn.dhx.netty.boot.cache.CacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {


    @GetMapping("/hi/{msg}")
    public Object fun1(@PathVariable("msg") String msg) {
//        timeClientHandler.sendMessage(msg);
        CacheUtil.send(msg);
        return "0k";
    }
}
