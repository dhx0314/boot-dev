package cn.dhx.bootdemo.demo;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Demo04 {

    public static void main(String[] args) {
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("a", "1");
        hashMap.put("b", "2");
        hashMap.put("c", "3");
        hashMap.put("d", "4");
        System.out.println(hashMap);
    }
}
