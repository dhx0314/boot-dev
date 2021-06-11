package cn.dhx.util.pool;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties
public class PoolProperties {

//    * 最大空闲
//     */

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
    private int initialSize = 3;
}
