package cn.dhx.boot.demo;

import cn.dhx.boot.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Demo01 {


    @Test
    public void fun1() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusMinutes(30);
        LocalDateTime localDateTime1 = localDateTime.plusMinutes(30);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);


        LocalDateTime localDateTime2 = now.plusHours(2);
        boolean after = localDateTime1.isBefore(localDateTime2);
        System.out.println(after);
        System.out.println(localDateTime2);
    }
}
