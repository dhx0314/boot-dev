package cn.dhx.boot.web;

import lombok.extern.slf4j.Slf4j;
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
}
