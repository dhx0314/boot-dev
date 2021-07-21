package cn.dhx.boot.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class WebDemo {


    @PostMapping("/test2")
    public String fun1() {
        log.info("test1-------------------------");
        return "ok92475897937";
    }


    @PostMapping("/test1")
    public String fun2() {
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
