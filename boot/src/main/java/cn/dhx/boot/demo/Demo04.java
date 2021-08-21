package cn.dhx.boot.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo04 {

    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newFixedThreadPool(600);
//        for (int i = 0; i <10; i++) {
//            executorService.execute(()->{
//                String string = Thread.currentThread().getName().toString();
//                System.out.println("name: "+string);
//            });
//        }


//        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
//        hashMap.put("","23");
//        hashMap.put("12s","23");
//        String s = hashMap.get("");
//        System.out.println(s.length());
//        String s1 = hashMap.get(null);
//        System.out.println(s1.length());
        LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<>();
        stringStringLinkedHashMap.put("1","");
        System.out.println(stringStringLinkedHashMap.size());

    }
}
