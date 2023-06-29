package cn.dhx.boot.controller;




import cn.dhx.boot.aop.Log;
import cn.dhx.boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 参数demo
 */

/**
 * @Author daihongxin
 * @create 2023/3/31 13:46
 */

@RestController
@Slf4j
@CrossOrigin
@Log
public class ParamController2 {

    @Log
    @GetMapping("/requestDemo")
    public Object requestDemo(@RequestParam(value = "name",required = false) String name,
                               @RequestParam(value = "age",required = false) Integer age,
                               @RequestBody String map) {
        log.info(name);
        log.info(String.valueOf(age));
        log.info("map {}",map);
        return new User(name, age);
    }

    @Log
    @GetMapping("/requestDemo2/{name}")
    public Object requestDemo2(@PathVariable(value = "name",required = false) String name,
                              @RequestBody String map) {
        log.info(name);
        log.info("map {}",map);
        return new User(name, 0);
    }


    @PostMapping("/requestDemo3")
    public Object postBytesInBody(@RequestParam(value = "name", required = false) String name, @RequestBody byte[] bytes) {
        String str = new String(bytes);
        int length = bytes.length;
        log.info("length {}", length);
        log.info("name {}", name);
        return "ok";
    }






}
