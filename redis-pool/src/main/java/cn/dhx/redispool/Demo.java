package cn.dhx.redispool;

import cn.dhx.redispool.clusterpool.ClusterPool;
import cn.dhx.redispool.clusterpool.ClusterPoolConfiguration;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;

public class Demo {

    public static void main(String[] args) {
//        HashSet<HostAndPort> set = new HashSet<>();
//        JedisCluster jedisCluster = new JedisCluster(set);
//        jedisCluster.close();
        String str="172.16.2.95:7001,172.16.2.95:7002,172.16.2.95:7003,172.16.2.95:7004,172.16.2.95:7005,172.16.2.95:7006";
        String[] split = str.split(",");
        HashSet<HostAndPort> node = new HashSet<>();
        for (String s : split) {
            String[] split1 = s.split(":");
            HostAndPort hostAndPort = new HostAndPort(split1[0],Integer.valueOf(split1[1]));
            node.add(hostAndPort);
        }


//
//        JedisCluster jedisCluster = new JedisCluster(node,100,100,100,"laihu",new GenericObjectPoolConfig());
//        return new DefaultPooledObject<JedisCluster>(jedisCluster);
   //     jedisCluster.set("a","a2");
//
//        ClusterPoolConfiguration poolAutoConfiguration = new ClusterPoolConfiguration();
//        ClusterPool clusterPool = poolAutoConfiguration.initSDKPool(node);

        ClusterPool clusterPool = ClusterPoolConfiguration.getClusterPoolConfiguration().initSDKPool(node);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                JedisCluster jedisCluster=null;
                try {
                    jedisCluster = clusterPool.borrowObject();
//                    jedisCluster.set("k"+ finalI, String.valueOf(finalI));
                    jedisCluster.hset("map","k"+ finalI,String.valueOf(finalI));
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    clusterPool.returnObject(jedisCluster);
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                JedisCluster jedisCluster=null;
                try {
                    jedisCluster = clusterPool.borrowObject();
                    String s = jedisCluster.get("k" + finalI);

                    String hget = jedisCluster.hget("map", "k" + finalI);
                    System.out.println(hget);
//                    System.out.println(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    clusterPool.returnObject(jedisCluster);
                }
            }).start();
        }

    }



}
