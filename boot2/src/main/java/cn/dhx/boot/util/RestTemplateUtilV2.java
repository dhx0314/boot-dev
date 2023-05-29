package cn.dhx.boot.util;

import cn.dhx.boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author daihongxin
 * @create 2023/3/31 13:46
 */
@Component
@Slf4j
public class RestTemplateUtilV2 {

    private static final int TIMEOUT = 2 * 1000;

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate() {
        OkHttp3ClientHttpRequestFactory httpRequestFactory = new OkHttp3ClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(TIMEOUT);
        httpRequestFactory.setReadTimeout(TIMEOUT);
        this.restTemplate = new RestTemplate(httpRequestFactory);
    }


    public void timeout() {
        String url = "http://127.0.0.1:9001/timeout";
        String str = restTemplate.getForObject(url, String.class);
        log.info(str);
    }



}
