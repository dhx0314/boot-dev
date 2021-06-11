package cn.dhx.boot.demo;


import org.junit.Test;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Demo2 {

    public static void main(String[] args) throws ParseException, InterruptedException {

        HashMap<String, List<String>> hashMap = new HashMap<>();
        List<String> strings = hashMap.get("1");
        ArrayList<String> strings1 = new ArrayList<>();
        strings1.add("a");
        strings1.add("b");
        hashMap.put("1",strings1);

        TimeUnit.SECONDS.sleep(10);
        List<String> strings2 = hashMap.get("1");
        strings2.add("c");

        List<String> strings3 = hashMap.get("1");
        strings3.forEach(x->{
            System.out.println(x);
        });

    }


    @Test
    public void fun1() {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();
        strings.add("a");
        strings.add("2");
        strings.add("c");
        strings2.add("1");
        strings2.add("2");
        strings2.add("3");

        for (String s : strings2) {
            for (String s1 : strings2) {
                System.out.println(s+"  "+s1);
                if (s.equals("2")) {
                    break;
                }

            }
        }


//        strings2.add("4");
//        strings2.add("5");
//        strings.forEach(x->{
//            AtomicBoolean flag= new AtomicBoolean(true);
//            if (flag.get()) {
//                strings2.forEach(y -> {
//
//                    if (x.equals(y)) {
//                        flag.set(false);
//                        return;
//                    }
//                    System.out.println(x + "-----" + y);
//                });
//            }
//        });

    }
}
