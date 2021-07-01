package cn.dhx.redispool;

import cn.dhx.redispool.clusterpool.ClusterPool;
import cn.dhx.redispool.clusterpool.ClusterPoolConfiguration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;

public class Demo {

    public static void main(String[] args) {
//        HashSet<HostAndPort> set = new HashSet<>();
//        JedisCluster jedisCluster = new JedisCluster(set);
//        jedisCluster.close();
//        String str="172.16.2.95:7001,172.16.2.95:7002,172.16.2.95:7003,172.16.2.95:7004,172.16.2.95:7005,172.16.2.95:7006";
        String str="192.168.232.128:7001,192.168.232.128:7002,192.168.232.128:7003,192.168.232.128:7004,192.168.232.128:7005,192.168.232.128:7006";
        String[] split = str.split(",");
        HashSet<HostAndPort> node = new HashSet<>();
        for (String s : split) {
            String[] split1 = s.split(":");
            HostAndPort hostAndPort = new HostAndPort(split1[0],Integer.valueOf(split1[1]));
            node.add(hostAndPort);
        }
//        ClusterPoolConfiguration poolAutoConfiguration = new ClusterPoolConfiguration();
//        ClusterPool clusterPool = poolAutoConfiguration.initSDKPool(node);

        ClusterPool clusterPool = ClusterPoolConfiguration.getClusterPoolConfiguration().initSDKPool(node);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                JedisCluster jedisCluster=null;
                try {
                    jedisCluster = clusterPool.borrowObject();
                    jedisCluster.set("k"+ finalI, String.valueOf(finalI));
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
                    System.out.println(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    clusterPool.returnObject(jedisCluster);
                }
            }).start();
        }

    }



}
