package cn.dhx.redispool.jedisconfig;

import cn.dhx.redispool.entity.RedisAgent;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RedisDaoDemo {

    public static void main(String[] args) {

//        String str="0|172.16.2.144:6379";
      String str="1|172.16.2.95:7001,172.16.2.95:7002,172.16.2.95:7003,172.16.2.95:7004,172.16.2.95:7005,172.16.2.95:7006|laihu";
        String[] split = str.split("\\|");
        RedisDao redisDao = null;
        for (String s : split) {
            System.out.println(s);
        }
        if (split.length>2) {
            redisDao=new RedisDao(split[0],split[1],split[2]);
        }else if (split.length==2){
           redisDao= new RedisDao(split[0],split[1]);
        }else {
            // error
        }
        String redisDeviceId = "Station:" + "6873";
        String agent1 = redisDao.get("",redisDeviceId);
        JsonObject asJsonObject = new JsonParser().parse(agent1).getAsJsonObject();
        String agentId = asJsonObject.get("agentId").getAsString();
        System.out.println(agentId);


////        agent.setAgentId(agentId);
//        System.out.println(agent1);
        redisDao.setRedisDataHash("map","k1",new RedisAgent("a100","100"));
        redisDao.setRedisDataHash("map","k2",new RedisAgent("b100","200"));
        redisDao.setRedisDataHash("map","k3",new RedisAgent("c100","300"));

//
//
//        redisDao.setex("k1","2","a",3200);


//        Map<String, RedisAgent> map = redisDao.getRedisAgentMaps("map");
//        Set<Map.Entry<String, RedisAgent>> entries = map.entrySet();
//        for (Map.Entry<String, RedisAgent> entry : entries) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//        long map1 = redisDao.getMapLen("map");
//        System.out.println(map1);
//
//
//        RedisDao.set2("k22222","3");
//        redisDao.setRedisData("kkk1","info222");

////        String kkk1 = redisDao.getRedisData("Station:6873");
//        String kkk1 = redisDao.getRedisData("kkk1");
//        System.out.println(kkk1);
//
//        redisDao.setRedisDataHash("1","2");

    }
}
