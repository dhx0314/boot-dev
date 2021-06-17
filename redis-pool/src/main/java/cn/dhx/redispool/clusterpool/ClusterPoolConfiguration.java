package cn.dhx.redispool.clusterpool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;

import java.util.HashSet;

public class ClusterPoolConfiguration {


    private ClusterPool clusterPool;

    private static ClusterPoolConfiguration instance;

    public static ClusterPoolConfiguration getClusterPoolConfiguration() {
        if (instance == null) {
            synchronized (ClusterPoolConfiguration.class) {
                if (instance == null) {
                    instance = new ClusterPoolConfiguration();
                }
            }
        }
        return instance;
    }


    public ClusterPool initSDKPool(HashSet<HostAndPort> node) {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(50);
        poolConfig.setMaxIdle(8);
        poolConfig.setMinIdle(5);
        ClusterPoolFactory clusterPoolFactory = new ClusterPoolFactory(node);
        clusterPool = new ClusterPool(clusterPoolFactory, poolConfig);
        init();
        return clusterPool;
    }

    // 初始化连接数
    public void init() {
        for (int i = 0; i < 5; i++) {
            try {
                clusterPool.addObject();
            } catch (Exception e) {
                //
            }
        }
    }
}
