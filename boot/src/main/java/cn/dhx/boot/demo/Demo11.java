package cn.dhx.boot.demo;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo11 {

    public static void main(String[] args) {
//        AtomicInteger atomicInteger = new AtomicInteger();
//        int i = atomicInteger.get();
//        System.out.println(i);
//        atomicInteger.set(1);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        System.out.println(strings.size());
        for (int i = 0; i < strings.size() - 1; i++) {
            System.out.println(strings.get(i));
        }
    }
}
