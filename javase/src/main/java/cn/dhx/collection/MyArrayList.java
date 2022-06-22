package cn.dhx.collection;

import org.junit.Test;

import java.util.ArrayList;

public class MyArrayList {

    @Test
    public void fun1() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("aa");
        int size = strings.size();
        System.out.println(size);
        ArrayList<String> strings1 = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            strings1.add(String.valueOf(i));
        }

        strings.addAll(strings1);
        System.out.println(strings.size());
    }
}
