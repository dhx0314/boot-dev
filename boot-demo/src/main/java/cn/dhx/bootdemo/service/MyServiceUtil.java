package cn.dhx.bootdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyServiceUtil {

    private static MyService myService;


    public static void send() {

        if (myService != null) {
            log.info("----MyServiceUtil-------");
            myService.send();
        } else {
            log.info("----null-------");
        }

    }

    public MyService getMyService() {
        return myService;
    }






//    @PostConstruct
    public void fun1(String s) {
        Object myServiceImpl = SpringUtils.getObject(s);

        MyService myServiceT= (MyService) myServiceImpl;
        myService=myServiceT;
    }


    public void stop() {
        myService = null;
        log.info(" myService = null;");
    }
}
