package cn.dhx.boot.web;

import cn.dhx.boot.demo.Demo01;
import cn.dhx.boot.demo.JsonResult;
import cn.dhx.boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class WebDemo {


    @GetMapping("list")
    public Object list() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("11");
        return strings;
    }


    @GetMapping("/test223")
    public JsonResult fun213() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("123","wwafer");
        stringStringHashMap.put("12we3","wwafer");


        HashMap<String, String> stringStringHashMap2 = new HashMap<>();
        stringStringHashMap2.put("1232","wwafer");
        stringStringHashMap2.put("12we23","wwafer");
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(stringStringHashMap);
        objects.add(stringStringHashMap2);
        User user = new User();
        user.setAge(100);
        user.setId(1);
        user.setName("zhangsan");
        JsonResult wa = new JsonResult("11", true, "wa", objects);
        JsonResult wa2 = new JsonResult("11", true, "wa");
        return wa2;
    }

//
//    @Autowired
//    Demo01 demo01;

    @GetMapping("/test22")
    public String fun21() {
//        Demo01.fun1();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        String a = stringStringHashMap.get("a");

        log.info("test1------------{}-------------",a);
        return "ok92475897937";
    }

    @PostMapping(value = "/hi/{deviceId}")
    public String monitorStation(@PathVariable("deviceId") String deviceId) {
        return "ok92475897937";
    }

    @PostMapping(value = "/monitorStation")
    public String monitorStation(@RequestBody Map<String, String> params) {
        log.info("receive monitorStation request {}", params);
        String deviceId = params.get("deviceId");
        return deviceId;
    }
    @PostMapping("/test2")
    public String fun12() {
        log.info("test1-------------------------");
        return "ok92475897937";
    }


    @PostMapping("/test1")
    public String fun22() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("test1-------------------------");
        return "ok-111";
    }


    @GetMapping("/test3")
    public void fun1a() {
        String s = null;
        try {

            String ss="11";
            System.out.println(ss);
            log.info("----"+ss);
            s.equals("2");
        } catch (Exception e) {

            e.printStackTrace();

            log.info("-----------------");
            log.info("----"+e.getCause().getMessage());
            log.info("===================");
        }
    }
}
