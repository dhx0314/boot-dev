package cn.dhx;


import cn.dhx.boot.util.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyFileTest {




    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Autowired
    private RestTemplateFileUtil restTemplateFileUtil;

    @Autowired
    private HttpdAndNginxFileUtil httpdAndNginxFileUtil;

    @Autowired
    private RestTemplateUtilV2 restTemplateUtilV2;


    @Test
    public void fun1tets() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                extracted();

//                String uri = RoundRobinUtil.selectUri();
//                log.info("uri {}",uri);
            }).start();
        }

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                RoundRobinUtil.selectUri();
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        TimeUnit.SECONDS.sleep(100);

    }

    private void extracted() {
        StringBuilder lastUri = new StringBuilder();
        String uri = "";
        for (int i = 0; i < RoundRobinUtil.getSize(); i++) {
            while (true) {
                uri = RoundRobinUtil.selectUri();
                boolean contains = lastUri.toString().contains(uri);
                if (!contains) {
                    lastUri.append(";").append(uri);
                    break;
                }
            }
        }
        log.info("uri {} lastUri {}", uri, lastUri);

    }

    @Test
    public void getAndPost() {

        //get
//        restTemplateUtil.getForObject();
//        restTemplateUtil.getForObject1();
//        restTemplateUtil.getForObject2();

//        restTemplateUtil.getForEntity();


        //post
//        restTemplateUtil.postForObject();
//        restTemplateUtil.postForObjectFormData();
//        restTemplateUtil.postForObjectFormDataFile();

//        restTemplateUtil.getBytesFromApi();
        restTemplateUtilV2.timeout();
    }


    @Test
    public void fileTest() {
//        restTemplateFileUtil.downLoad();
//        restTemplateFileUtil.upload();
        restTemplateFileUtil.upload2();
//        restTemplateFileUtil.testDownLoadBigFile();
    }

    @Test
    public void nginxFileTest() {
//        httpdAndNginxFileUtil.downLoadFile();
//        httpdAndNginxFileUtil.uploadFile();
    }




}
