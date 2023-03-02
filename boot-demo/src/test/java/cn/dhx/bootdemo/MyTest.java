package cn.dhx.bootdemo;


import cn.dhx.bootdemo.entity.Filedetail;
import cn.dhx.bootdemo.entity.MyDetial;
import cn.dhx.bootdemo.util.HostUtil;
import cn.dhx.bootdemo.util.JasyptUtil;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {



    @Autowired
    private StringRedisTemplate redisTemplate;


    @Autowired
    private StringEncryptor encryptor;


    @Autowired
    private JasyptUtil jasyptUtil;

    @Test
    public void fun44() {
        redisTemplate.opsForValue().set("k","v2");
    }


    @Test
    public void fun4sd4() {
        jasyptUtil.test();
    }

    @Test
    public void fun122() {
        String hostName = HostUtil.getHostName();
        System.out.println(hostName);
//        redisTemplate.opsForValue().set("k","v");
    }

}
