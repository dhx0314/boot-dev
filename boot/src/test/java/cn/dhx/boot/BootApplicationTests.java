package cn.dhx.boot;

import cn.dhx.boot.demo.PkgProcessor;
import cn.dhx.boot.redis.DemoRedis;
import cn.dhx.boot.thread.Demo;
//import cn.dhx.boot.thread2.Stu;
import cn.dhx.boot.thread2.Stu;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class BootApplicationTests {

    @Autowired
    PkgProcessor pkgProcessor2;

    @Autowired
    DemoRedis demoRedis;

    @Autowired
    RestTemplate restTemplate;


    @Autowired
    private Stu stu;



    @Test
    void contextLoads() {

        PkgProcessor.getInstance().fun1();
        PkgProcessor instance = PkgProcessor.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(pkgProcessor2.hashCode());
    }


    @Test
    public void fun1() {
        demoRedis.fun1();
    }



    @Test
    public void fun3() {

        String stationExistUrl="http://172.16.2.144:8091/passive-recorder/stationExist";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("station",Integer.valueOf("1001"));
        String json=null;
        try {
            json = objectMapper.writeValueAsString(hashMap);
        } catch (JsonProcessingException e) {
            log.info("stationExist  json fail");
//            return Result.fail(ResultCode.RECORDER_STATION_INSERT_FAIL);
        }
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<String> exchange = restTemplate.exchange(stationExistUrl, HttpMethod.POST, request, String.class);
        System.out.println(exchange);
        System.out.println(exchange.getStatusCodeValue());
        System.out.println(exchange.getStatusCode());
        System.out.println(exchange.getBody());
        String body = exchange.getBody();
        try {
            JsonNode jsonNode = objectMapper.readTree(body);
            String returnCode = jsonNode.get("returnCode").asText();
            System.out.println(returnCode);
            if ("1".equals(returnCode)) {
                System.out.println("1-----");
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

}
