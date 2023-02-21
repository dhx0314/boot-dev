package cn.dhx.bootdemo.util;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author daihongxin
 * @create 2023/2/21 16:19
 */

@Component
@Slf4j
public class JasyptUtil {




    @Value("${spring.redis.password}")
    private String redisPW;

    @Autowired
    private StringEncryptor encryptor;


    public void test() {
        log.info("redis pw {}",redisPW);
    }


}
