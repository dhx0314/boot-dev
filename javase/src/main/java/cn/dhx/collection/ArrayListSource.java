package cn.dhx.collection;

import org.junit.Test;

import java.util.ArrayList;

public class ArrayListSource {

    @Test
    public void fun1() {
//        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>(1);
        for (int i = 1; i <=10; i++) {
            arrayList.add(String.valueOf(i));
        }

        for (int i = 11; i <=15; i++) {
            arrayList.add(String.valueOf(i));
        }

        arrayList.add("100");
        arrayList.add("200");
        arrayList.add(null);
    }
}
