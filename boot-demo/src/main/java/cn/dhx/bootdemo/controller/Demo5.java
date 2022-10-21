package cn.dhx.bootdemo.controller;


import cn.dhx.bootdemo.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
public class Demo5 {


    @GetMapping("put")
    public void fun1tt() {

    }


    @PostMapping("/scsa-api/webext/iqas/v4/syncdr/00000000128802")
    @ResponseBody
    public Object getpush(@RequestBody String data) {
        log.info("-"+data.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("fn_code",0);
        hashMap.put("fs_msg","1");
        return hashMap;
    }


    @PostMapping("/scsa-api/webext/iqas/v4/syncdr/000000001288022")
    @ResponseBody
    public Object getpush2(@RequestBody String data) throws JsonProcessingException {
        log.info("-"+data.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("fn_code",0);
        hashMap.put("fs_msg","1");
        String s = objectMapper.writeValueAsString(hashMap);
        return s;
    }


    @PostMapping("/scsa-api/webext/iqas/v4/syncdr/000000001288023")
    @ResponseBody
    public Object getpush3(@RequestBody User user) throws JsonProcessingException {
        log.info("-"+user.toString());
        log.info("-"+user.getName());
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("fn_code",0);
        hashMap.put("fs_msg","1");
        String s = objectMapper.writeValueAsString(hashMap);
        return s;
    }
}

