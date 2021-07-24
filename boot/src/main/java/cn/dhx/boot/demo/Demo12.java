package cn.dhx.boot.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo12 {
    public static void main(String[] args)  {

//
        List<String> list2 = new ArrayList<>();
        list2.add("123");
        list2.add("2332");
        list2.add("awef");
        list2.add("awe324f");

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(list2);
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println("o  "+next);
            if(next.equals("awef")) {
//                iterator.remove();
                list.remove(next);
            }
            System.out.println(next);
            System.out.println(list.size());
        }

        System.out.println("-----------------");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
