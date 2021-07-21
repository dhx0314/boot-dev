package cn.dhx.boot.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo11 {
    public static void main(String[] args)  {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();

            if(integer==2)
//                list.remove(integer)
            {
                iterator.remove();
            }
            System.out.println(integer);
        }

//
//        List<Integer> list2 = new ArrayList<Integer>();
//        list2.add(3);
//        list2.add(2);
//        list2.add(1);
//        list2.add(4);
//
//        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(list2);
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            Integer integer = iterator.next();
//            System.out.println(integer);
//            if(integer==2) {
////                iterator.remove();
//                list.remove(integer);
//            }
//        }
//
//        System.out.println("-----------------");
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }
    }
}
