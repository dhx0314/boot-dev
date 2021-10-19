package cn.dhx.boot.demo;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo05 {

    public static void main(String[] args) {

        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<String>();
        strings.add("100");
        strings.add("200");
        strings.add("300");
        Collections.reverse(strings);
        for (String string : strings) {
            System.out.println(string);
        }


        JsonResult jsonResult = new JsonResult();
        System.out.println(jsonResult);

        String code = jsonResult.getCode();
        System.out.println(code);
        jsonResult.setMessage(code);
    }
}
