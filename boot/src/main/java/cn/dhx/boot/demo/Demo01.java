package cn.dhx.boot.demo;

import cn.dhx.boot.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;

public class Demo01 {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap.put("aa","bbb");
        hashMap.put("bb",hashMap2);
        hashMap2.put("ee","cc");
        String s = objectMapper.writeValueAsString(hashMap);
        System.out.println(s);
    }
}
