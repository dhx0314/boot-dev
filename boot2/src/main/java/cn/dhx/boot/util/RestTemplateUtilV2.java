package cn.dhx.boot.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
