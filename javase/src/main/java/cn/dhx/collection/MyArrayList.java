package cn.dhx.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void fun2() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Object[] objects = arrayList.toArray();
        System.out.println(Arrays.toString(objects));
    }

    @Test
    public void fun3() {
        String [] list = new String[]{"1","2"};
        List<String> strings = Arrays.asList(list);
        strings.add("333");
        //java.lang.UnsupportedOperationException


//        public static <T> List<T> asList(T... a) {
//            return new Arrays.ArrayList<>(a);
//        }
    }

    @Test
    public void fun4() {
        String [] list = new String[]{"1","2"};
        List<String> strings = Arrays.asList(list);
        ArrayList<String> arrayList = new ArrayList<>(strings);
        arrayList.add("333");
        System.out.println(arrayList);
    }
}
