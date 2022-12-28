package cn.dhx.bootdemo.json.jackson;

import cn.dhx.bootdemo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class Demo {

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setAddr("addr");
        user.setAge(18);
        user.setName("aa");
        System.out.println(user.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);
        HashMap<String,Object> hashMap = objectMapper.readValue(s, HashMap.class);
        System.out.println(hashMap);
//        for (Map.Entry<String, Object> stringObjectEntry : hashMap.entrySet()) {
//            String key = stringObjectEntry.getKey();
//            Object value = stringObjectEntry.getValue();
//            System.out.println(key+"___"+value);
//        }

        String s1 = objectMapper.writeValueAsString(hashMap);
        User user1 = objectMapper.readValue(s1, User.class);
        System.out.println(user1);
    }
}
