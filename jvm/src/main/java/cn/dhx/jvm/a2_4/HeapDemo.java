package cn.dhx.jvm.a2_4;

import java.util.concurrent.TimeUnit;

public class HeapDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1----");
        TimeUnit.SECONDS.sleep(30);
        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println("2------");
        TimeUnit.SECONDS.sleep(20);
        bytes=null;
        System.gc();
        System.out.println("3------");
        TimeUnit.SECONDS.sleep(100);
    }
}
