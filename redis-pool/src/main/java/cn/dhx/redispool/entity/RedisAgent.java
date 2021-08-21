package cn.dhx.redispool.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RedisAgent {

    private String agentId;
    private String deviceId;


}
