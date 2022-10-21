package cn.dhx.bootdemo;

import cn.dhx.bootdemo.config.ConfigurationConfig;
import cn.dhx.bootdemo.entity.Filedetail;
import cn.dhx.bootdemo.entity.MyDetial;
import cn.dhx.bootdemo.entity.User2;
import cn.dhx.bootdemo.pojo.DemoData;
import cn.dhx.bootdemo.pojo.RecFile;
import cn.dhx.bootdemo.util.DateUtil;
import cn.dhx.bootdemo.util.JsonUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class BootDemoApplicationTests {


    @Autowired
    private RestTemplate template;


    @Autowired
    private ConfigurationConfig configurationConfig;




}
