package cn.dhx.boot.ftp.ftppool;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@EnableConfigurationProperties(PoolProperties.class)
@Configuration
public class FtpPoolAutoConfiguration {
    @Autowired
    private FtpConfig config;

    private FtpPool pool;

    @Autowired
    private FtpClientFactory ftpClientFactory;

    public FtpPoolAutoConfiguration(FtpConfig config) {
        this.config = config;
    }

    //    @ConditionalOnClass({TestObjectFactory.class})
    @Bean
    protected FtpPool initFtpPool() {
//        //设置对象池的相关参数
//        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
//        poolConfig.setMaxIdle(config.getMaxIdle());
//        poolConfig.setMaxTotal(config.getMaxTotal());
//        poolConfig.setMinIdle(config.getMinIdle());
//        poolConfig.setBlockWhenExhausted(true);
//        poolConfig.setTestOnBorrow(true);
//        poolConfig.setTestOnReturn(true);
//        poolConfig.setTestWhileIdle(true);
//        poolConfig.setTimeBetweenEvictionRunsMillis(1000 * 60 * 30);
//        //一定要关闭jmx，不然springboot启动会报已经注册了某个jmx的错误
//        poolConfig.setJmxEnabled(false);
//
//        //新建一个对象池,传入对象工厂和配置
//        pool = new FtpPool(ftpClientFactory, poolConfig);
//
//        initPool(config.getInitialSize(), config.getMaxIdle());
//        return pool;
        return null;
    }

    /**
     * 预先加载testObject对象到对象池中
     *
     * @param initialSize 初始化连接数
     * @param maxIdle     最大空闲连接数
     */
    private void initPool(int initialSize, int maxIdle) {
        if (initialSize <= 0) {
            return;
        }

        int size = Math.min(initialSize, maxIdle);
        for (int i = 0; i < size; i++) {
            try {
                pool.addObject();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //    @PreDestroy
    public void destroy() {
        if (pool != null) {
            pool.close();
        }
    }
}
