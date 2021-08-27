package cn.dhx.boot.gson;

import cn.dhx.boot.entity.User;
import cn.dhx.boot.thread2.Stu;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;

public class GsonDemo {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(1);
        user.setId(2);
//        user.setName("aa");
        Gson gson = new Gson();
        String json = gson.toJson(user);
        System.out.println(json);
//        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
//        String name = jsonObject.get("name").getAsString();
//        try {
//            String name2 = jsonObject.get("na2me").getAsString();
//        } catch (Exception e) {
//
//        }

//        System.out.println(name);

        Gson gson1 = new Gson();
        User user1 = gson1.fromJson(json, User.class);
        System.out.println(user1);


        HashMap<String, Object> map = new HashMap<>();
        map.put("aa","aa");
        map.put("bb","bb");
        map.put("user",json);
        map.put("user2",user);
        String json1 = gson.toJson(map);
        System.out.println(json1);
    }
}
