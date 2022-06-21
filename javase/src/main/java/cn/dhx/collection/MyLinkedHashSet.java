package cn.dhx.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class MyLinkedHashSet {


    @Test
    public void fun1() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("aa1");
        linkedHashSet.add("aa2");
        linkedHashSet.add("aa3");

        System.out.println(linkedHashSet.toString());
    }



    @Test
    public void fun2() {
        HashSet<Object> hashSet = new LinkedHashSet<>(64);
        for (int i = 0; i < 12; i++) {
            hashSet.add(new A(i));
        }

    }

}

