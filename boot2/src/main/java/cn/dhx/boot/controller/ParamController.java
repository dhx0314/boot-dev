package cn.dhx.boot.controller;




import cn.dhx.boot.aop.Log;
import cn.dhx.boot.pojo.User;
import cn.dhx.boot.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
public class ParamController {

    @Log
    @GetMapping("/requestParam")
    public Object requestParam(@RequestParam(value = "name",required = false) String name, @RequestParam(value = "age",required = false) Integer age) {
        log.info(name);
        log.info(String.valueOf(age));
        return new User(name, age);
    }

    @Log
    @GetMapping("/requestParamNo")
    public Object requestParam2(@RequestParam(value = "name",required = false,defaultValue = "defaultName") String name, @RequestParam(value = "age",required = false) Integer age) {
        log.info(name);
        log.info(String.valueOf(age));
        return new User(name, age);
    }


    /**
     * 表单
     *
     * @param name
     * @param age
     */
    @Log
    @PostMapping("/requestParamFromData")
    public Object requestParamFromData(@RequestParam( "name") String name, @RequestParam(value = "age",required = false) Integer age) {
        log.info(name);
        log.info(String.valueOf(age));
        return new User(name, age);
    }


    @Log
    @GetMapping("/requestParam2")
    public Object requestParam2(String name, String age) {
        log.info(name);
        log.info(age);
        return new User(name, Integer.valueOf(age));
    }

    @Log
    @GetMapping("/getToBody")
    public Object getBody(User user) {
        log.info(user.toString());
        return user;
    }

    @Log
    @GetMapping("/pathVariable/{name}/{age}")
    public Object pathVariable(@PathVariable("name") String name, @PathVariable("age") int age) {
        log.info(name);
        log.info(String.valueOf(age));
        return new User(name, age);
    }

    @Log
    @PostMapping("/requestBody")
    public Object requestBody(@RequestBody User user) {
        log.info(user.toString());
        return user;
    }

    @Log
    @PostMapping("/requestBody/map")
    public Object map(@RequestBody Map<String, String> map) {
        log.info(map.toString());
        log.info(map.get("name"));
        log.info(map.get("age"));
        return map.toString();
    }

    @Log
    @PostMapping("/requestBody/list")
    public void list(@RequestBody List<User> user) {
        user.forEach(x->{
            log.info(x.toString());
        });
    }





    @Log
    @PostMapping("/requestBody/str")
    public void requestBodyStr(@RequestBody String user) {
        log.info("para "+user.toString());
        User user1 = JsonUtil.toObject(user, User.class);
        log.info(user1.toString());

    }

    @Log
    @PostMapping("/requestBody/array")
    public void list2(@RequestBody User[] user) {

        log.info("aa  {}",Arrays.toString(user));

    }


}
