package cn.dhx.boot.util;

import cn.dhx.boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author daihongxin
 * @create 2023/3/31 13:46
 */
@Component
@Slf4j
public class RestTemplateFileUtil {



    @Autowired
    private RestTemplate restTemplate;

    /**
     * 表单+文件  发送文件
     */
    public void upload() {

        String url = "http://127.0.0.1:9001/form/data/file";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("name","formDataFile");
        String filePath = "file\\send.txt";
        File file = new File(filePath);
        boolean exists = file.exists();
        log.info("file exists {}", exists);
        FileSystemResource resource = new FileSystemResource(file);
        map.add("file", resource);


        // 组装请求体
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);

        String result = restTemplate.postForObject(url, request, String.class);
        System.out.println(result);
    }

    public void upload2() {

        String url = "http://127.0.0.1:9001/form/data/file2";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("name","formDataFile");
        String filePath = "file\\send.txt";
        File file = new File(filePath);
        boolean exists = file.exists();
        log.info("file exists {}", exists);
        FileSystemResource resource = new FileSystemResource(file);
        map.add("file", resource);
        User user = new User();
        user.setId(1234);
        user.setName("test");
        String json = JsonUtil.toString(user);
        map.add("json", json);


        // 组装请求体
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);

        String result = restTemplate.postForObject(url, request, String.class);
        System.out.println(result);
    }

    public void downLoad() {
        String url = "http://127.0.0.1:9001/download";
        ResponseEntity<byte[]> rsp = restTemplate.getForEntity(url, byte[].class);
        log.info("文件下载请求结果状态码 {}" , rsp.getStatusCode());
        log.info("文件大小 {}" , rsp.getBody().length);
    }

     public void testDownLoadBigFile()  {

        try {


            String url = "http://127.0.0.1:9001/download";

            RequestCallback requestCallback = request -> request
                    .getHeaders()
                    .setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
            //对响应进行流式处理而不是将其全部加载到内存中
            ResponseExtractor<Void> responseExtractor = response -> {
                // Here you can write the inputstream to JULTest file or any other place
                String targetPath = "file\\downLoadBig.txt";
                Path path = Paths.get(targetPath);
                Files.copy(response.getBody(), path);
                return null;
            };
            restTemplate.execute(url, HttpMethod.GET, requestCallback, responseExtractor);
        } catch (Exception e) {
            log.error("error ",e);
        }
    }
}
