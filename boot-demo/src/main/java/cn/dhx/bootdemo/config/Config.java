package cn.dhx.bootdemo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Configuration
@Component
@Data
public class Config {


    @Value("${aa.bb}")
    private String tt;

    @Value("#{${maps}}")
    private HashMap<String,String> maps;


}
