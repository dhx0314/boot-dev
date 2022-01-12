package cn.dhx.boot.demo;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo14 {
    public  static  final ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
//        String aa = FileCacheUtil.getOrUpdate("aa");
//        System.out.println(aa);
//        String aa1 = FileCacheUtil.getOrUpdate("aa");
//        System.out.println(aa1);
//        hashMap.remove("aaaa");
        AtomicInteger count = new AtomicInteger(0);
        ArrayList<String> lists = new ArrayList<>();
        lists.add("aa");
        lists.add("bb");
        lists.add("cc");
        for (int j = 0; j < 100; j++) {
            int size = lists.size();
            int index=0;
            if (size > 0) {
                int i = count.getAndIncrement();

                if (i >= size - 1) {
                    index = size - 1;
                    count.set(0);
                } else {
                    index = i;
                }
            }
            System.out.println("--"+index);
        }

    }
}
