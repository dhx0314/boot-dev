package cn.dhx.boot.demo;

import cn.dhx.boot.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class Demo01 {
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User();
        user.setName("aatt");
        System.out.println(user.toString());
        System.out.println(user);
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<Object, Object> hashMap = new HashMap<>();
        String string1 = objectMapper.writeValueAsString(user);
        hashMap.put("aa","11");
        hashMap.put("bb",user);
        hashMap.put("dd",string1);
        hashMap.put("cc",user.toString());
        String string = objectMapper.writeValueAsString(hashMap);
        System.out.println(string);
    }
}
