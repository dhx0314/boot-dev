package cn.dhx.jvm.reference;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


// 软引用、
// -Xmx20m  -XX:+PrintGCDetails -verbose:gc

public class WeakDemo {
    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
//        ArrayList<byte[]> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(new byte[_4MB]);
//        }
//
//        System.in.read();
        weak();
    }


    public static void weak() {

        List<WeakReference<byte[]>> list = new ArrayList<>();

//        WeakReferenceQueue<byte[]> queue=new WeakReferenceQueue<>();

        for (int i = 0; i < 6; i++) {
            // 关联了引用队列，当软引用所关联的 byte[]被回收时，软引用自己会加入到queue中去
            WeakReference<byte[]> reference = new WeakReference<>(new byte[_4MB]);
            list.add(reference);
            for (WeakReference<byte[]> weakReference : list) {
                System.out.print(weakReference.get()+" ");
            }
            System.out.println();
        }
        System.out.println("ok ---------- "+list.size());


    }
}
