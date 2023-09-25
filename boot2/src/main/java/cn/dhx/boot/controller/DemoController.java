package cn.dhx.boot.controller;


import cn.dhx.boot.aop.Log;
import cn.dhx.boot.pojo.User;
import cn.dhx.boot.service.UserService;
import cn.dhx.boot.vo.MyVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
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
    public Object timeout(@RequestBody String data)  {
        log.info("timeout {}",data);
        return "ok";
    }


    @Log
    @PostMapping("/vo/array")
    public void list2(HttpServletRequest request) {
        String body = ReadAsChars(request);
        log.info("body{}",body);
//        log.info("aa  {}", Arrays.toString(myVos));

        userService.test();


    }




    public static String ReadAsChars(HttpServletRequest request)
    {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
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
