package cn.dhx.boot.web;


import cn.dhx.boot.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ParameterController2 {






    //  127.0.0.1:8001/requestParam?name=aa&age=18
    // 127.0.0.1:8080/requestParam?name=aa&age=10&addr=tt
    @PostMapping("/requestParam")
    public void fun1(@RequestParam("name") String name, @RequestParam("age") int age) {
        System.out.println(name);
        System.out.println(age);
    }

    //  127.0.0.1:8001/requestParam2?name=aa&age=18
    @PostMapping("/requestParam2")
    public void fun2(String name, int age) {
        System.out.println(name);
        System.out.println(age);
    }


    //    json
    //      127.0.0.1:8001/requestBody
    //curl --location --request POST '127.0.0.1:8001/requestBody' \
    //--header 'Content-Type: application/json' \
    //--data-raw '{
    //    "id":1,
    //    "name":"aa",
    //    "age":18
    //}'
    @PostMapping("/requestBody")
    public void fun3(@RequestBody User user) {
        System.out.println(user.toString());
    }


    // 127.0.0.1:8001/requestBody2?id=1&name=aa&age=18
    @PostMapping("/requestBody2")
    public void fun4(User user) {
        System.out.println(user.toString());
    }



    //curl --location --request POST '127.0.0.1:8001/requestBody/List' \
    //--header 'Content-Type: application/json' \
    //--data-raw '[
    //    {
    //        "id":1,
    //        "name":"aa",
    //        "age":18
    //    },
    //    {
    //        "id":2,
    //        "name":"bb",
    //        "age":20
    //    }
    //]'

    @PostMapping("/requestBody/List")
    public void fun3(@RequestBody List<User> user) {
        user.forEach(x->{
            System.out.println(x);
        });
    }


    //curl --location --request POST '127.0.0.1:8001/requestBody/map' \
    //--header 'Content-Type: application/json' \
    //--data-raw '{
    //    "userName":"aa",
    //    "passWord":"bb"
    //}'
    @PostMapping("/requestBody/map")
    public void login(@RequestBody Map<String, String> map) {
        System.out.println(map.get("userName"));
        System.out.println(map.get("passWord"));
    }

    //127.0.0.1:8001/pathVariable/aa/18
    @PostMapping("/pathVariable/{name}/{age}")
    public void fun5(@PathVariable("name") String name, @PathVariable("age") int age) {
        System.out.println(name);
        System.out.println(age);
    }


}
