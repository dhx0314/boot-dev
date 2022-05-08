package cn.dhx.Collection;

import org.junit.Test;

import java.util.*;

public class MyCollection {


    @Test
    public void fun1() {

        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("bb");
        list.add("aa");
        System.out.println(list.toString());
        list.remove("bb");
        System.out.println(list.toString());
    }

    @Test
    public void fun2() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        Iterator<String> iterator = list.iterator();//得到一个集合的迭代器
        // hasNext 判断是否还有下一个元素
        while (iterator.hasNext()) {
            // next 指针下移,将下移后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void fun3() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void fun4() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add("bb");
        list.add(null);
        System.out.println(list.toString());
        //[null, bb, null]



    }
}
