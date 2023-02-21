package cn.dhx.bootdemo.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


@Configuration
@Component
@Data
@Slf4j
public class ConfigurationConfig {


    @Value("${aa.bb}")
    private String tt;

    @Value("#{${maps}}")
    private HashMap<String,String> maps;


    @PostConstruct
    public void fun() {
        log.info("maps {}",maps.toString());
    }


}
