package cn.dhx.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MyHashMap {



    @Test
    public void fun1a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("01", "aa");
        hashMap.put("02", "bb");
        hashMap.put("03", "cc");

        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }

        hashMap.forEach((k, v) -> {
            System.out.println(k + "--" + v);
        });


        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            String value = hashMap.get(key);
            System.out.println(key + "--" + value);
        }
    }



    @Test
    public void fun1() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("01", "aa");
        hashMap.put("02", "bb");
        System.out.println(hashMap.get("")); //null
        System.out.println(hashMap.get(null)); // null

        int size = hashMap.size();
        System.out.println(size);

    }

    @Test
    public void fun2() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("01", "aa");
        concurrentHashMap.put("02", "bb");
        System.out.println(concurrentHashMap.get(""));  //null
        System.out.println(concurrentHashMap.get(null)); //java.lang.NullPointerException
    }

    // table扩容
    @Test
    public void fun41() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        for (int i = 10; i < 22; i++) {
            hashMap.put(i, new Object());
        }
        System.out.println(hashMap);
        hashMap.put(23, new Object());
    }


    // 树化
    @Test
    public void fun3() {
        HashMap<Object, Object> hashMap = new HashMap<>(64);
        for (int i = 0; i < 8; i++) {
//        for (int i = 0; i < 9; i++) {
            hashMap.put(new A(i), new Object());
        }
        System.out.println(hashMap);
        for (int i = 8; i < 20; i++) {
            hashMap.put(new A(i), new Object());
        }
    }



    // 树化 -> 变回链表
    @Test
    public void fun3a() {
        HashMap<Object, Object> hashMap = new HashMap<>(64);
        for (int i = 0; i < 9; i++) {
            hashMap.put(new A(i), new Object());
        }
        hashMap.remove(new A(8));
        hashMap.remove(new A(7));
        hashMap.remove(new A(6));
        System.out.println(hashMap.size());
        for (int i = 200; i <240 ; i++) {
            hashMap.put(new A(i), new Object());
        }
        for (int i = 300; i <318 ; i++) {
            hashMap.put(new A(i), new Object());
        }
        System.out.println(hashMap.toString());

    }

    @Test
    public void fun4() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        for (int i = 0; i < 11; i++) {
            hashMap.put(i, new Object());
        }
        System.out.println(hashMap);
        for (int i = 11; i < 20; i++) {
            hashMap.put(i, new Object());
        }
    }



}


class A {

    private int i;

    public A(int i) {
        this.i = i;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return i == a.i;
    }

    @Override
    public int hashCode() {
        if (i < 100) {
            return 4;
        }else {
            return 101;
        }

    }
}
