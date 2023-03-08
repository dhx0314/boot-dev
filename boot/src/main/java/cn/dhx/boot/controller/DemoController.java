package cn.dhx.boot.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author daihongxin
 * @create 2023/3/8 15:27
 */

@RestController
@Slf4j
public class DemoController {


    @PostMapping("md5")
    public Object md5(@RequestBody HashMap<String, String> hashMap) {
        String path = hashMap.get("path");
        String md5Hex = "";
        try {
            md5Hex = DigestUtils.md5Hex(new FileInputStream(path));
            log.info("path {} md5hex {}", path, md5Hex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return md5Hex;
    }
}
