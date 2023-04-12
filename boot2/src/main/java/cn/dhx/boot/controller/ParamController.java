package cn.dhx.boot.controller;




import cn.dhx.boot.aop.Log;
import cn.dhx.boot.entity.User;
import cn.dhx.util.JsonUtil;
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
public class ParamController {

    @Log
    @GetMapping("/requestParam")
    public void requestParam(@RequestParam(value = "name",required = false) String name, @RequestParam(value = "age",required = false) Integer age) {
        System.out.println(name);
        System.out.println(age);
    }


    /**
     * 表单
     *
     * @param name
     * @param age
     */
    @Log
    @PostMapping("/requestParamFromData")
    public void requestParamFromData(@RequestParam( "name") String name, @RequestParam(value = "age",required = false) Integer age) {
        System.out.println(name);
        System.out.println(age);
    }


    @Log
    @GetMapping("/requestParam2")
    public void requestParam2(String name, String age) {
        System.out.println(name);
        System.out.println(age);
    }

    @Log
    @GetMapping("/getToBody")
    public void getBody(User user) {
        System.out.println(user.toString());
    }

    @Log
    @GetMapping("/pathVariable/{name}/{age}")
    public void pathVariable(@PathVariable("name") String name, @PathVariable("age") int age) {
        System.out.println(name);
        System.out.println(age);
    }

    @Log
    @PostMapping("/requestBody")
    public void requestBody(@RequestBody User user) {
        System.out.println(user.toString());

    }

    @Log
    @PostMapping("/requestBody/map")
    public String map(@RequestBody Map<String, String> map) {
        System.out.println(map.toString());
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
        return map.toString();
    }

    @Log
    @PostMapping("/requestBody/list")
    public void list(@RequestBody List<User> user) {
        user.forEach(x->{
            System.out.println(x);
        });
    }





    @Log
    @PostMapping("/requestBody/str")
    public void requestBodyStr(@RequestBody String user) {
        System.out.println("para "+user.toString());
        User user1 = JsonUtil.toObject(user, User.class);
        System.out.println(user1);

    }


}
