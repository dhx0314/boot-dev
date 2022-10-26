package cn.dhx.webflux;

import cn.dhx.util.pojo.JsonResult;
import cn.dhx.webflux.controller.WebController;
import cn.dhx.webflux.Webclient.WebClientDemo;
import cn.dhx.webflux.util.WebClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class WebfluxApplicationTests {





    @Autowired
    private WebController webDemo;


    @Test
    public void funstring() {
        String name=System.getProperty("os.name");
        if (StringUtils.isNotBlank(name) && name.contains("Windows")) {
            return;
        }
    }

    @Test
    public void funa23()  {
//        webDemo.funmono();
//        webDemo.funmono2()
//
        String postUrl = "http://127.0.0.1:8099/passive-recorder/noticeRecFile";
        HashMap<String, String> map = new HashMap<>();
        map.put("ani","1234");
        map.put("dnis","12345");
        JsonResult post = WebClientUtil.post2(postUrl, map);
        log.info("post {}",post.toString());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



























}
