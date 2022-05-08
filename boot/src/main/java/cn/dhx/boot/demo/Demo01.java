package cn.dhx.boot.demo;

import cn.dhx.boot.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;

public class Demo01 {
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User();
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        user.setName("a");
        for (User user1 : users) {
            System.out.println(user);
        }
    }
}
