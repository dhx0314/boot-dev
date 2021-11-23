package cn.dhx.bootdemo.controller;


import cn.dhx.bootdemo.entity.User2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @GetMapping("/hello")
    public Object fun1() {
        log.info("---------------");
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
