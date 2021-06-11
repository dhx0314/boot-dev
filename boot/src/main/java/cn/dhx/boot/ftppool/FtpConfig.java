package cn.dhx.boot.ftppool;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "ftp")
public class FtpConfig {

    private String host;

    private int port;

    private String username;

    private String password;

    private int maxIdle = 5;
    /**
     * 最大总数
     */
    private int maxTotal = 20;
    /**
     * 最小空闲
     */
    private int minIdle = 2;

    /**
     * 初始化连接数
     */
    private int initialSize = 0;


}
