package cn.dhx.boot.controller;

import cn.dhx.boot.aop.Log;
import cn.dhx.boot.entity.User;
import cn.dhx.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @Author daihongxin
 * @create 2023/4/12 20:07
 */
@RestController
@Slf4j
@CrossOrigin
@Log
public class RestDemoController {

    @Log
    @PostMapping(value = "/form/data", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Object formData(String name, Integer age) {


        return new User(name, age);
    }

    @Log
    @PostMapping(value = "/form/data/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Object formDataFile(String name, Integer age, @RequestParam(value = "file") MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        log.info("originalFilename    {}", originalFilename);

        byte[] bytes = multipartFile.getBytes();
        log.info("file size {}", bytes.length);

        return new User(name, age);
    }


    @Log
    @PostMapping(value = "/form/data/file2", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Object formDataFile(String name, String json, @RequestParam(value = "file") MultipartFile multipartFile) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        log.info("originalFilename    {}", originalFilename);

        byte[] bytes = multipartFile.getBytes();
        log.info("file size {}", bytes.length);

        User user = JsonUtil.toObject(json, User.class);
        log.info("user {}", user.toString());

        return new User(name, 10);
    }
}
