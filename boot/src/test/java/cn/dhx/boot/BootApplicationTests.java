package cn.dhx.boot;

import cn.dhx.boot.autoconfig.AppProp;
import cn.dhx.boot.autoconfig.AppProperties;
import cn.dhx.boot.config.Person;
//import cn.dhx.boot.ftp.FileUtil;
//import cn.dhx.boot.ftp.config.FtpConfigProperties;

import cn.dhx.boot.ftppool.FtpPool;

import cn.dhx.boot.httpd.Upload;
import cn.dhx.boot.kafka.KafkaProducerDemo;
//import cn.dhx.boot.thread2.StuDemo;
import cn.dhx.boot.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class BootApplicationTests {



//    @Autowired
//    private MyService myService;

    @Autowired
    private MyServiceUtil myServiceUtil;


    @Test
    public void fun2() {

//        MyServiceUtil.send();

//        Object myServiceImpl = SpringUtils.getObject("myServiceImpl2");
//        MyService MyService= (MyService) myServiceImpl;
//        MyService.send();
            myServiceUtil.fun1("myServiceImpl2");
            MyServiceUtil.send();

        myServiceUtil.fun1("abc");
        MyServiceUtil.send();
//        myService.send();
//        System.out.println("---------------");
//
//        try {
//            Object sti = SpringUtils.getBean("st2i");
//        } catch (Exception e) {
//            log.info("erroe",e);
//        }




    }
}
