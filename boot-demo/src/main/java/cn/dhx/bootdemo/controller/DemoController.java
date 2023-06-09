package cn.dhx.bootdemo.controller;


import cn.dhx.bootdemo.annotation.Log;
import cn.dhx.bootdemo.entity.User2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

@RestController
@Slf4j
public class DemoController {


    @Value("${aa.bb:}")
    String string;

    @Value("${aa.cc}")
    private boolean flag;

    @PostMapping("/test23")
    public String fun23(HttpServletRequest request)  throws Exception{
        BufferedReader bufferReader = new BufferedReader(request.getReader());
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = bufferReader.readLine()) != null) {
            sb.append(line);
        }
        log.info("data {}",sb.toString());
        return sb.toString();
    }


    @GetMapping("/test2")
    public void fun22() throws UnsupportedEncodingException {
        String s = new String(string.getBytes("ISO-8859-1"), "UTF-8");

        log.info("old {} ",string);
        log.info("UTF-8 {} ",s);
    }

    @GetMapping("/error")
    public void fun1awewa() {


        log.info("--"+flag);
//        System.out.println(flag);

//        String s="1";
//        try {
//
//            int i=1/0;
//        } catch (Exception e) {
//            log.error("[{}] aa ",s,e);
//        }


    }


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


    @PostMapping("/prod-api/extension/isOnLine2")
    @ResponseBody
    public Object getpush2(@RequestBody String data) throws JsonProcessingException {
        log.info("-"+data.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code",200);
        hashMap.put("push","1");
        String s = objectMapper.writeValueAsString(hashMap);
        return s;
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





    @GetMapping("/hello2233")
    @Log
    public Object fun1() {

        log.info("---------------");
        log.info("aa {}", string);
        boolean empty = string.isEmpty();
        log.info("{}", empty);
        User2 user2 = new User2();
        return user2;
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
