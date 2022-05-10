package cn.dhx.Collection;

import org.junit.Test;

import java.util.HashSet;

public class MyHashSet {


    @Test
    public void fun1() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("aa");
        hashSet.add("bb");
        hashSet.add("aa");
        hashSet.add("cc");
        hashSet.add(null);
        hashSet.add(null);
        System.out.println(hashSet.toString());

    }
}
