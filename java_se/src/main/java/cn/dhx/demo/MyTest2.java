package cn.dhx.demo;

import cn.dhx.util.DateToolUtil;
import cn.dhx.util.JsonUtil;
import cn.dhx.util.User2UserInfoUtil;
import cn.hutool.core.lang.UUID;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/16 11:14
 */
@Slf4j
public class MyTest2 {


    @Test
    public void fun1() {
        String uui = "7b22757365724964223a3132333435367d;encoding=jsonHex";

        String uuiStr = User2UserInfoUtil.decodeHex(uui);
        HashMap<String, String> hashMap = JsonUtil.toObject(uuiStr, new TypeReference<HashMap<String, String>>() {
        });
        String userId = hashMap.get("userId");
        System.out.println(userId);


        Map<String, Object> decode = User2UserInfoUtil.decode(uui);
        System.out.println(decode.get("userId"));


        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("a", "b");

    }


    @Test

    public void fun3() {

        ArrayList<String> list = new ArrayList<>();
        list.forEach(i-> System.out.println("aa"));


    }


}
