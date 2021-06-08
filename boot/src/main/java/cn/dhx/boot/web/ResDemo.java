package cn.dhx.boot.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("res")
public class ResDemo {


    @GetMapping("hi")
    public Object fun1() {
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("status","success");
        resultMap.put("code","info");
        resultMap.put("message","error");
        return resultMap;
    }
}
