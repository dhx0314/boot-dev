package cn.dhx.jvm.reference;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;


// 软引用、
// -Xmx20m  -XX:+PrintGCDetails -verbose:gc

public class SoftDemo {
    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
//        ArrayList<byte[]> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(new byte[_4MB]);
//        }
//
//        System.in.read();
        soft();
    }


    public static void soft() {

        List<SoftReference<byte[]>> list = new ArrayList<>();

        //引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        for (int i = 0; i < 5; i++) {
            // 关联了引用队列，当软引用所关联的 byte[]被回收时，软引用自己会加入到queue中去
            SoftReference<byte[]> reference = new SoftReference<>(new byte[_4MB], queue);
            System.out.println(reference.get());
            list.add(reference);
            System.out.println(list.size());
        }

        // 从队列中获取无用的 软引用对象 并移除
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null) {
            list.remove(poll);
            poll=queue.poll();
        }
        System.out.println("---------------------------");
        System.out.println("--------ok  " + list.size());
        for (SoftReference<byte[]> softReference : list) {
            System.out.println(softReference.get());
        }
    }
}
