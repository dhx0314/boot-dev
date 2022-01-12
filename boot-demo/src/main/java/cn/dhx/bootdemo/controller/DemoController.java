package cn.dhx.bootdemo.controller;


import cn.dhx.bootdemo.entity.User2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Slf4j
public class DemoController {


    @Value("${aa.bb:}")
    String string;


    @PostMapping("/prod-api/extension/isOnLine")
    @ResponseBody
    public Object getpush(@RequestBody String data) {
        log.info("-"+data.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code",200);
        hashMap.put("push","1");
        return hashMap;
    }

    @GetMapping("/demo")
    public String aa() {
        new Thread(() -> {
            try {
                Demo4.fun();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Demo4.fun2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        return "0k";
    }





    @GetMapping("/hello")
    public Object fun1() {

        log.info("---------------");
        log.info("aa {}", string);
        boolean empty = string.isEmpty();
        log.info("{}", empty);
        return "hello";
    }

    @PostMapping("/hello2")
    public String fun1(@RequestBody String body) {
        System.out.println(body);
        ObjectMapper objectMapper = new ObjectMapper();
        User2 user2 = null;
        try {
            user2 = objectMapper.readValue(body, User2.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(user2);
        log.info("---------------");
        return "hello";
    }
}
