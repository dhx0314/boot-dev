package cn.dhx.boot.async;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aysnc")
public class DemoController {


    @Autowired
    private ServiceDemo serviceDemo;

    @GetMapping("/hi")
    public String fun1() {
        System.out.println(Thread.currentThread().getName());

        String result;
        System.out.println("testAsyncController() start...");

         new Thread(()->{
             serviceDemo.getResult();
         }).start();

        System.out.println("testAsyncController() end...");
        return "结果:" + "result";

    }
}
