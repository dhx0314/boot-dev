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
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class BootApplicationTests {


//    @Autowired
//    private MyService myService;

    @Autowired
    private MyServiceUtil myServiceUtil;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    Upload upload;

    @Test
    public void fun2waef() {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 30001; i < 30003; i++) {
            log.info("---------aa---------");
            fixedThreadPool.execute(() -> {
                log.info("---------Thread---------");
            });
            log.info("---------bb---------");
        }
    }

    @Test
    public void funawe1() {
        String downPath = "http://172.16.2.144:8010/vox/a.wav";
        String upPath = "http://172.16.2.144:8010/vox/b.wav";
        upload.downAndUploadFile(downPath, upPath);

    }

    @Test
    public void fun2aeaw() throws JsonProcessingException, InterruptedException {
        String url = "http://172.16.2.144:8082/api/startREC";

        Random r = new Random(1);
//        for (int j = 0; j < 1; j++) {


        for (int i = 30001; i < 30501; i++) {
            int finalI = i;
            HashMap<Object, Object> hashMap = new HashMap<>();
            String s = UUID.randomUUID().toString();
            hashMap.put("sessionId", s);
            hashMap.put("deviceId", String.valueOf(finalI));
            hashMap.put("deviceIp", s);
            ObjectMapper objectMapper = new ObjectMapper();
            String s1 = null;
            try {
                s1 = objectMapper.writeValueAsString(hashMap);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                log.info("--------");
            }
//            log.info("j" + j + "i " + i);
                log.info("i "+i);
            log.info("json" + s1);
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            HttpEntity<String> formEntity = new HttpEntity<String>(s1.toString(), headers);
            String s2 = restTemplate.postForEntity(url, formEntity, String.class).getBody();
            log.info(s2);
        }
//            TimeUnit.SECONDS.sleep(150);
//        }
//    }
    }


    @Test
    public void fun1() {

//        String stopUrl = String.format("http://%s/rtvoice-proxy/rtvoice/stop", rtvoiceUrl);


        String url = "http://172.16.2.144:8082/api/startREC";

//        for (int i = 30001; i <30100; i++) {
        HashMap<String, String> request = new HashMap<>();

//            {
//                "sessionId":"2387439279474",
//                    "deviceId":"1005",
//                    "deviceIp":"172.16.3.180"
//            }
        String s = UUID.randomUUID().toString();
        int i = 1005;
        request.put("sessionId", "234242");
        request.put("deviceId", String.valueOf(i));
        request.put("deviceIp", "127.0.0.1");
        WebClient.create(url)
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(e -> {
                    log.error("---error-----");
//                    log.error("[{}] deviceId [{}] ERROR post stop MRCP request [{}]!", callId, deviceId, e);
                })
                .subscribe(res -> {
                    log.info(res);

                });
//        }

    }


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
