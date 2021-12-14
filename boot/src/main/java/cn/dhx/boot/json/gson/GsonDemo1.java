package cn.dhx.boot.json.gson;

import cn.dhx.boot.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

public class GsonDemo1 {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setAge(2);
        user.setName("aa");
        user.setAddr("aefgearwf");


        Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").excludeFieldsWithoutExposeAnnotation().create();
        String s = gson.toJson(user);
        System.out.println(s);


        Gson gson1 = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String s1 = gson1.toJson(user);
        System.out.println(s1);


        Gson gson2 = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").excludeFieldsWithModifiers(Modifier.PROTECTED).create();
        String s2 = gson2.toJson(user);
        System.out.println(s2);

    }
}
