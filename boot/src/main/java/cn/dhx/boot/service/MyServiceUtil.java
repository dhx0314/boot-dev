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
