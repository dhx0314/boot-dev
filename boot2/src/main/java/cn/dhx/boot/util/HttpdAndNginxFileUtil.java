package cn.dhx.boot.util;

import cn.dhx.boot.aop.Log;
import cn.dhx.util.Byte2StreamUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.UUID;

/**
 * @Author daihongxin
 * @create 2023/4/14 11:37
 */

@Component
@Slf4j
public class HttpdAndNginxFileUtil {


    @Autowired
    private RestTemplate restTemplate;

    public void downLoadFile() {
        try {
            String httpUrl = "http://dhxdhx.top:10010/a.txt";
            HttpHeaders headers = new HttpHeaders();
            headers.set("authorization", "Basic " +
                    Base64.getEncoder().encodeToString("root:dhx@root".getBytes()));
            ResponseEntity<byte[]> response = restTemplate.exchange(
                    httpUrl,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    byte[].class);

            byte[] body = response.getBody();
            log.info("body size {}", body.length);
        } catch (Exception e) {
            log.error("downLoadFile error", e);
        }
    }


    // 待测试
    public void uploadFile() {
        try {
            String httpUrl = "http://dhxdhx.top:10010/send.txt";
            String upLoadPath = "file\\send.txt";
            File file = new File(upLoadPath);
            boolean exists = file.exists();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = Byte2StreamUtil.toByteArray(bufferedInputStream);
            log.info("file exists {}", exists);
            HttpHeaders headers = new HttpHeaders();
            headers.set("authorization", "Basic " +
                    Base64.getEncoder().encodeToString("root:dhx@root".getBytes()));
            ResponseEntity<String> exchange = restTemplate.exchange(httpUrl, HttpMethod.PUT, new HttpEntity<>(headers), String.class, bytes);
            String body = exchange.getBody();
            log.info("exchange body {} ", body);
        } catch (Exception e) {
            log.error("uploadFile error", e);
        }
    }

    // 待测试
    public void deleteFile() {
        String httpUrl = "http://dhxdhx.top:10010/send.txt";
        restTemplate.delete(httpUrl);
    }
}
