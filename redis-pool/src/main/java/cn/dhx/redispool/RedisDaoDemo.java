package cn.dhx.redispool;

import cn.dhx.redispool.Redis.RedisDao;

public class RedisDaoDemo {

    public static void main(String[] args) {

        String str="1|172.16.2.144:6379|a";
        String[] split = str.split("\\|");
        for (String s : split) {
            System.out.println(s);
        }
        if (split.length>2) {
            new RedisDao(split[0],split[1],split[3]);
        }else if (split.length==2){
            new RedisDao(split[0],split[2]);
        }else {
            // error
        }

    }
}
