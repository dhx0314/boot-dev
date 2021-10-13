package cn.dhx.boot.demo;

import java.util.concurrent.ConcurrentHashMap;

public class Demo04 {

    public static void main(String[] args) {

        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        String put = hashMap.put("k1", "v1");
        String k1 = hashMap.remove("k1");
        System.out.println(k1);
    }
}
