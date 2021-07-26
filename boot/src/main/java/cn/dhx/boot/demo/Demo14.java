package cn.dhx.boot.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo14 {
    public static void main(String[] args) {
//        int maxValue = 20000;
//        System.out.println(maxValue);
//        int i = (int) (maxValue *5);
//        int i1 = i / 1024;
//        System.out.println(i);
//        System.out.println(i1);


        long l = System.currentTimeMillis()/1000;
        System.out.println(l);

        long l2=1627107913;
        long l1 = l - l2;
        if (l1 > 60) {
            System.out.println("-----------------");
        }
        System.out.println("1627107913");

        long l3=1111/1000;
        System.out.println(l3);



//        AtomicInteger atomicInteger = new AtomicInteger(0);
//        for (int i = 0; i < 8; i++) {
//            int andIncrement = atomicInteger.getAndIncrement();
//        }
//
//        int andIncrement = atomicInteger.getAndIncrement();
//        atomicInteger=new AtomicInteger(0);
//        System.out.println(andIncrement);
//        System.out.println(atomicInteger.get());


    }
}
