package cn.dhx.redispool.clusterpool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisCluster;

public class ClusterPool extends GenericObjectPool<JedisCluster> {
    public ClusterPool(PooledObjectFactory<JedisCluster> factory) {
        super(factory);
    }

    public ClusterPool(PooledObjectFactory<JedisCluster> factory, GenericObjectPoolConfig<JedisCluster> config) {
        super(factory, config);
    }

    public ClusterPool(PooledObjectFactory<JedisCluster> factory, GenericObjectPoolConfig<JedisCluster> config, AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
}
