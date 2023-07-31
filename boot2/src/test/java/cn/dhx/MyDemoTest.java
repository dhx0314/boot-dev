package cn.dhx;

import cn.dhx.boot.entity.User;
import cn.dhx.boot.filter.RedissonBloomFilter;
import cn.dhx.boot.service.MyService;
import cn.dhx.boot.util.JsonUtil;
import cn.dhx.boot.util.RestTemplateUtil;
import cn.dhx.boot.util.WebClientUtil;
import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author daihongxin
 * @create 2023/7/13 17:17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MyDemoTest {


    @Autowired
    private MyService myService;

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private RedissonBloomFilter redissonBloomFilter;


    @Test
    public void fun1a() {
        String url = "https://172.16.6.106/api/v1/tagent/agentAction";


        HashMap<String, String> body = new HashMap<>();
        body.put("userkey", "1001");
        body.put("usersession", "uuid");
        body.put("agentaction", "startmovie");
        String s = restTemplate.postForObject(url, body, String.class);
        log.info("str {} ", s);
    }

    @Test
    public void fun2() {
        String videoUrl = "https://172.16.6.106/api/v1/tagent/agentAction";

        String deviceId = "1001";
        String uuid = "uuid";
        HashMap<String, String> body = new HashMap<>();
        body.put("userkey", deviceId);
        body.put("usersession", uuid);
        body.put("agentaction", "startmovie");
        String block = WebClientUtil.create(videoUrl)
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
//                .timeout(Duration.ofMillis(TIMEOUT))
                .doOnError(e -> {
                    log.error("[{}] deviceId [{}] ERROR post startVideo request [{}]!", deviceId, uuid, e);
                }).block();
        log.info("block");
//                .subscribe(res -> {
//                    Map<String, Object> map = JsonUtil.toObject(res, new TypeReference<Map<String, Object>>() {
//                    });
//                    Integer code = (Integer) map.get("code");
//                    if (code != null && 0 == code) {
//                        log.info("startVideo deviceId {} uuid {} success res {}", deviceId, uuid, res);
//                    }else {
//                        log.error("startVideo deviceId {} uuid {} error res {}", deviceId, uuid, res);
//                    }
//                });
    }


    @Test
    public void fun4() {
        String url = "https://172.16.6.106/api/v1/tagent/agentAction";


        HashMap<String, Object> body = new HashMap<>();
        body.put("userkey", "1001");
        body.put("usersession", "uuid");
        body.put("agentaction", "startmovie");
        String result= HttpUtil.post(url, JsonUtil.toString(body));
        log.info("result {}",result);
    }

    @Test
    public void fun1() {
        System.out.println(myService.toString());
        System.out.println(MyService.getInstance());
    }

    @Test
    public void funBloom() {
        redissonBloomFilter.testBloom();
    }



}
