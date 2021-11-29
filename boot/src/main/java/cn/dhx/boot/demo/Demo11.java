package cn.dhx.boot.demo;

import java.util.concurrent.ConcurrentHashMap;

public class Demo11 {

    public static void main(String[] args) {
        ConcurrentHashMap<String, JsonResult> hashMap = new ConcurrentHashMap<>();
        JsonResult k = hashMap.get("k");
        System.out.println(k);
        if (k == null) {
            System.out.println("------------");
        }
    }
}
