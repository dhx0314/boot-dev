package cn.dhx.bootdemo;

import cn.dhx.bootdemo.config.PropertiesUtil;
import cn.dhx.bootdemo.util.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @Author daihongxin
 * @create 2023/2/21 19:42
 */

@Component
@Slf4j
public class Start {

    private static PropertiesUtil propertiesUtil;


//    @PostConstruct
//    public void start() {
//        String projectName = propertiesUtil.getProperty("project.name");
//    }

    @Autowired
    void setPropertiesUtil(PropertiesUtil util) {
        propertiesUtil = util;
        init();
    }


    public void init() {
        String projectName = propertiesUtil.getProperty("aa.bb");
        System.out.println(projectName);

        String mpss = propertiesUtil.getProperty("hashmap");
        System.out.println(mpss);

        HashMap<String, String> hashMap = JsonUtil.toObject(mpss, new TypeReference<HashMap<String, String>>() {
        });

        hashMap.forEach((x,y)->{
            log.info("x {} y {}",x,y);
        });


        String s = hashMap.get("key1");
        System.out.println(s);

//        System.out.println(mpss);
//        JsonUtil.toObject(mpss)


    }
}
