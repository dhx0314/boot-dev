package cn.dhx.webflux.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class WebDemo {


    @PostMapping("/test2")
    public String fun1() {
        log.info("test1-------------------------");
        return "ok92475897937";
    }

    @PostMapping("/test3")
    public Object fun3() throws JsonProcessingException {
        HashMap<String, String> map = new HashMap<>();
        map.put("a","fffffffffffffff");
        map.put("2","2");
        map.put("3","2");
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s1 = objectMapper.writeValueAsString(map);
//        JsonNode jsonNode = objectMapper.readTree(s1);
//        String s = jsonNode.get("a").asText();
//        log.info("---s"+s);
//        System.out.println(s);
        return map;
    }


    @PostMapping("/test1")
    public String fun2() {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("test1-------------------------");
        return "ok-111";
    }
}
