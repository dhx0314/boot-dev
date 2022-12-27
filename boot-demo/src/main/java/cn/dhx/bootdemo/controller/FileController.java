package cn.dhx.bootdemo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.HashMap;

@RestController
@Slf4j
public class FileController {


//    @PostMapping("/test")
//    public String mkdirs(@RequestBody HashMap<String,String> data) {
//        String path = data.get("path");
//        log.info("path {}",path);
//        File file = new File(path);
//        if (!file.exists()) {
//            boolean mkdirs = file.mkdirs();
//            log.info("mkdirs {}",mkdirs);
//        }
//        log.info("file {}",file.isDirectory());
//        return "ok";
//    }
}
