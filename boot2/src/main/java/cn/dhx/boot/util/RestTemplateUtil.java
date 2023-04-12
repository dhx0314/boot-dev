package cn.dhx.boot.util;

import cn.dhx.boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author daihongxin
 * @create 2023/3/31 13:46
 */
@Component
@Slf4j
public class RestTemplateUtil {


    /**
     * RestTemplate是Spring提供的一个简化HTTP请求的工具类，可以发送HTTP请求并处理响应结果。
     * 使用RestTemplate发送HTTP请求，需要以下步骤：
     * <p>
     * 1.创建RestTemplate实例
     * 可以使用无参构造函数创建RestTemplate实例，也可以使用RestTemplateBuilder构造器创建。
     * 2.设置请求头
     * 设置请求头可以使用RestTemplate提供的方法setHeader，也可以使用HttpHeaders类。
     * 3.设置请求参数
     * 设置请求参数可以使用RestTemplate提供的方法setVariable，也可以使用Map类型的参数。
     * 4.发送请求
     * 发送请求可以使用RestTemplate提供的方法getForObject、getForEntity、postForObject、postForEntity等。
     * 5.处理响应结果
     * 处理响应结果可以使用RestTemplate提供的方法getBody、getHeaders、getStatusCode等。
     */

    @Autowired
    private RestTemplate restTemplate;


    /**
     * getForObject()返回值是HTTP协议的响应体。getForEntity()返回的是ResponseEntity，
     * ResponseEntity是对HTTP响应的封装，除了包含响应体，还包含HTTP状态码、contentType、contentLength、Header等信息
     */

    public void getForObject() {
        String url = "http://127.0.0.1:9001/pathVariable/{1}/{2}";
        String name = "zhangsan0";
        int age = 20;
        String str = restTemplate.getForObject(url, String.class, name, age);
        log.info(str);
    }


    public void getForObject1() {
        String url = "http://127.0.0.1:9001/pathVariable/{name}/{age}";
        String name1 = "zhangsan1";
        int age = 30;
        // 顺序很重要
        String str = restTemplate.getForObject(url, String.class, name1, age);
        log.info(str);
    }

    public void getForObject2() {
        String url = "http://127.0.0.1:9001/pathVariable/{name}/{age}";

        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan2");
        map.put("age", 40);
        String str = restTemplate.getForObject(url, String.class, map);
        log.info(str);
    }

    public void getForEntity() {
        String url = "http://127.0.0.1:9001/pathVariable/{1}/{2}";
        String name = "entity";
        int age = 20;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, name, age);
        String body = responseEntity.getBody();
        log.info(body);

        //以下是getForEntity比getForObject多出来的内容
        HttpStatus statusCode = responseEntity.getStatusCode(); // 获取响应码
        int statusCodeValue = responseEntity.getStatusCodeValue(); // 获取响应码值
        HttpHeaders headers = responseEntity.getHeaders(); // 获取响应头

        System.out.println("HTTP 响应状态：" + statusCode);
        System.out.println("HTTP 响应状态码：" + statusCodeValue);
        System.out.println("HTTP Headers信息：" + headers);
    }


    /**
     * postForObject()返回值是HTTP协议的响应体。postForEntity()返回的是ResponseEntity，
     * ResponseEntity是对HTTP响应的封装，除了包含响应体，还包含HTTP状态码、contentType、contentLength、Header等信息
     */

    public void postForObject() {
        String url = "http://127.0.0.1:9001/requestBody";
        String name = "zhangsan_postForObject";
        int age = 30;
        User user = new User(name, age);
        String s = restTemplate.postForObject(url, user, String.class);
        log.info("user {} ", s);
    }


    /**
     * 表单
     */
    public void postForObjectFormData() {
        String url = "http://127.0.0.1:9001/form/data";



        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("name","formdata");
        map.add("title", "testTitle");
        map.add("body", "testBody");

        // 组装请求体
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);

        String result = restTemplate.postForObject(url, request, String.class);
        System.out.println(result);
    }


    /**
     * 表单+文件
     */
    public void postForObjectFormDataFile() {

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


    public void postForEntity() {
        String url = "http://127.0.0.1:9001/requestBody";
        String name = "zhangsan_postForEntity";
        int age = 30;
        User user = new User(name, age);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, user, String.class);
        String body = responseEntity.getBody();
        log.info("user {} ", body);

        //以下是postForEntity比postForObject多出来的内容
        HttpStatus statusCode = responseEntity.getStatusCode(); // 获取响应码
        int statusCodeValue = responseEntity.getStatusCodeValue(); // 获取响应码值
        HttpHeaders headers = responseEntity.getHeaders(); // 获取响应头


        System.out.println("HTTP 响应状态：" + statusCode);
        System.out.println("HTTP 响应状态码：" + statusCodeValue);
        System.out.println("HTTP Headers信息：" + headers);

    }
}
