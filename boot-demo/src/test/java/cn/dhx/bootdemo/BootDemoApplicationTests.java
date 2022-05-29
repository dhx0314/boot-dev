package cn.dhx.bootdemo;

import cn.dhx.bootdemo.config.Config;
import cn.dhx.bootdemo.entity.User2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
class BootDemoApplicationTests {


    @Autowired
    private RestTemplate template;


    @Autowired
    private Config config;


    @Test
    public void fun1() {
        String cc = config.getTt();
        System.out.println(cc);
        HashMap<String, String> m = config.getMaps();
        System.out.println(m);
    }

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("----------");
        User2 user2 = new User2();
        user2.setName("aa");
        user2.setAge("10");
        user2.setAddr("mmm");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user2);
//        String url="127.0.0.1:19991/hello2";
        String url2="http://127.0.0.1:19991/hello2";
        ResponseEntity<String> stringResponseEntity = template.postForEntity(url2, s, String.class);
        System.out.println(stringResponseEntity.toString());
    }

}
