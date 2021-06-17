package cn.dhx.redispool.clusterpool;

import org.apache.commons.pool2.DestroyMode;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;

public class ClusterPoolFactory implements PooledObjectFactory<JedisCluster> {


    private HashSet<HostAndPort> node;

    public ClusterPoolFactory(HashSet<HostAndPort> node) {
        this.node = node;
    }

    @Override
    public PooledObject<JedisCluster> makeObject() throws Exception {
        JedisCluster jedisCluster = new JedisCluster(node);
        return new DefaultPooledObject<JedisCluster>(jedisCluster);
    }

    @Override
    public void destroyObject(PooledObject<JedisCluster> pooledObject) throws Exception {
        JedisCluster jedisCluster = pooledObject.getObject();
        jedisCluster.close();
    }

    @Override
    public boolean validateObject(PooledObject<JedisCluster> pooledObject) {
        return false;
    }

    @Override
    public void activateObject(PooledObject<JedisCluster> pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject<JedisCluster> pooledObject) throws Exception {

    }


}
