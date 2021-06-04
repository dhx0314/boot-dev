package cn.dhx.boot.web;

import cn.dhx.boot.httpd.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestDemo {



    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Upload upload;

    @GetMapping("a1")
    public String fun1() {
        System.out.println("fun1");
        return "fun1";
    }

    @GetMapping("a2")
    public String fun2() {
        String forObject = restTemplate.getForObject("http://localhost:8080/a1", String.class);
        System.out.println(forObject);
        System.out.println("fun2");
        return "fun2";
    }


    @GetMapping("a3")
    public String fun3() {
        System.out.println("fun3");
        String downPath="http://172.16.2.144:8010/vox/a.wav";
        String upPath="http://172.16.2.144:8010/vox/b.wav";
        upload.downAndUploadFile(downPath,upPath);
        return "fun3";
    }


    @GetMapping("a4")
    public String fun4() {
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8080/a5/{id}/{age}", HttpMethod.POST, null, String.class, "a22",22);
        return "fun4";
    }

    @PostMapping("a5/{id}/{age}")
    public String fun5(@PathVariable("id") String id,@PathVariable("age") int age) {
        System.out.println(age);
        System.out.println(id);
        return "fun45";
    }

    @PostMapping("a6")
    public String fun6() {
        System.out.println("fun1");
        return "fun1";
    }



}
