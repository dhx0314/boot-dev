package cn.dhx.jvm.a4_5;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class JvmDemo {


    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 * 1024 * 1024;
    private static final int _7MB = 7 * 1024 * 1024;
    private static final int _8MB = 8 * 1024 * 1024;

    // -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
//        list.add(new byte[_7MB]);
//        list.add(new byte[_512KB]);
//        list.add(new byte[_512KB]);

//        list.add(new byte[_8MB]);


//        list.add(new byte[_8MB]);
//        list.add(new byte[_8MB]);

        new Thread(()->{
            ArrayList<byte[]> list1 = new ArrayList<>();
            list1.add(new byte[_8MB]);
            list1.add(new byte[_8MB]);
        }).start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------");
    }
}
