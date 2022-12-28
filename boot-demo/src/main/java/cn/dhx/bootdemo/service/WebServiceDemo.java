package cn.dhx.bootdemo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class WebServiceDemo {


    @Autowired
    private MyServiceUtil myServiceUtil;

    @Value("${aa.bb}")
    private String demo;

//    @PostConstruct
    public void fun1aa() {
        log.info("------@PostConstruct---------------");
        log.info(demo);
        myServiceUtil.fun1("abc");
        MyServiceUtil.send();
    }

    @GetMapping("/start")
    public String get() {
        myServiceUtil.fun1("abc");
        return "11";
    }

    @GetMapping("/send")
    public String fun2() {
//        myServiceUtil.fun1("abc");
        MyServiceUtil.send();
        return "11";
    }


    @GetMapping("/stop")
    public String funbbb() {
        myServiceUtil.stop();
        return "11";
    }
}
