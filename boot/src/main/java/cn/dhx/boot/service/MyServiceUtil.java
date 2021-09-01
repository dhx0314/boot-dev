package cn.dhx.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Slf4j
@Component
public class MyServiceUtil {

    private static MyService myService;

    private String aa;


    public static void send() {
        log.info("----MyServiceUtil-------");
        myService.send();
    }

    public MyService getMyService() {
        return myService;
    }

    @Value("${aa.bb}")
    public void setAa(String aa) {
        this.aa = aa;
        log.info(this.aa);

    }




    @Autowired
    @Qualifier("myServiceImpl2")
    void setMyService(MyService myService) {
        log.info("myService");
        this.myService = myService;
        send();
    }


//    @Autowired
//    @Qualifier("abc")
//    void setMyService2(MyService myService) {
//        log.info("myService");
//        this.myService = myService;
//    }

//    @PostConstruct
    public void fun1(String s) {
        Object myServiceImpl = SpringUtils.getObject(s);
        MyService myServiceT= (MyService) myServiceImpl;
//        MyService.send();
        myService=myServiceT;
    }
}
