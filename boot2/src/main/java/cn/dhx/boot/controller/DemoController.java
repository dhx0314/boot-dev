package cn.dhx.boot.controller;


import cn.dhx.boot.aop.Log;
import cn.dhx.boot.dao.UserDao;
import cn.dhx.boot.entity.User;
import cn.dhx.boot.pojo.AttrGroupRelationVo;
import cn.dhx.boot.pojo.ExecuteResult;
import cn.dhx.boot.service.UserService;
import cn.dhx.boot.util.LinuxCommandUtil;
import cn.dhx.boot.vo.MyVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/3/8 15:27
 */

@RestController
@Slf4j
@Log
public class DemoController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;


    @Log
    @GetMapping("linux")
    public Object linux() {
//        ArrayList<String> list = new ArrayList<>();
//        list.add("ll");
//        ExecuteResult execute = LinuxCommandUtil.execute(list, new File("/home"));
//        log.info("execute {}",execute.toString());

        executeLinux("ll");

        return "ok";
    }

    private void executeLinux(String command){
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c", command);
            Process process = processBuilder.start();
            // 获取命令输出
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                log.info("{}",line);
            }
            // 获取命令错误输出
            InputStream errorStream = process.getErrorStream();
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
            while ((line = errorReader.readLine()) != null) {
                log.info("{}",line);
            }
            // 等待命令执行完成
            int exitCode = process.waitFor();
            System.out.println("命令执行完成，退出码：" + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Log
    @GetMapping("hi")
    public Object hi() {
        log.info("aa");
        return "aa";
    }


    @Log
    @GetMapping("hello")
    public Object hello() {
        log.info("hello");
        return "aa";
    }

    @PostMapping("test")
    public Object timeout(@RequestBody String data) {
        log.info("timeout {}", data);
        return "ok";
    }

    @GetMapping("user")
    public Object fun2() {
        User user = userDao.selectById(1);
        log.info("user {}", user);
        return user;
    }


    @Log
    @PostMapping("/vo/array")
    public void list2(@RequestBody AttrGroupRelationVo[] vos) {

//        String body = ReadAsChars(request);
        log.info("body   {}", vos);
//        log.info("aa  {}", Arrays.toString(myVos));

//        userService.test();


    }

    @Log
    @PostMapping("/vo/list")
    public void list2(@RequestBody List<AttrGroupRelationVo> vos) {

//        String body = ReadAsChars(request);
        log.info("body   {}", vos);
//        log.info("aa  {}", Arrays.toString(myVos));

//        userService.test();


    }


    public static String ReadAsChars(HttpServletRequest request) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }


    public static String getPostData(HttpServletRequest request) {
        StringBuilder data = new StringBuilder();
        String line;
        BufferedReader reader;
        try {
            reader = request.getReader();
            while (null != (line = reader.readLine())) {
                data.append(line);
            }
        } catch (IOException e) {
            return null;
        }
        return data.toString();
    }


}
