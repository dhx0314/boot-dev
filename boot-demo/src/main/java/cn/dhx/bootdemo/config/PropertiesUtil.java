package cn.dhx.bootdemo.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 获取properties配置文件中的配置值
 */
@Configuration
@Service
public class PropertiesUtil {
    @Resource
    private Environment env;

    public String getProperty(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        String property = "";
        try {
            property = env.getProperty(key);
        } catch (Exception e) {
        }
        return property;
    }

    public String getProperty(String key, String defaultValue) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        String property = "";
        try {
            property = env.getProperty(key, defaultValue);
        } catch (Exception e) {
        }
        return property;
    }

}

