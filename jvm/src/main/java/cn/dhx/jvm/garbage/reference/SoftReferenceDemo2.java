package cn.dhx.jvm.garbage.reference;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author daihongxin
 * @create 2023/6/8 10:28
 *
 * 软引用,引用队列
 */
@Slf4j
public class SoftReferenceDemo2 {

    private static final int _4MB = 4 * 1024 * 1024;


    // -Xmx20m -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) {
        List<SoftReference<byte[]>> list = new ArrayList<>();

        // 引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        for (int i = 0; i < 5; i++) {
            // 关联了引用队列， 当软引用所关联的 byte[]被回收时，软引用自己会加入到 queue 中去
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB], queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
            System.out.print("SoftReference: ");
            for (SoftReference<byte[]> w : list) {
                System.out.print(" "+w.get()+" ");
            }
            System.out.println();
        }

        // 从队列中获取无用的 软引用对象，并移除
        Reference<? extends byte[]> poll = queue.poll();
        while( poll != null) {
            list.remove(poll);
            poll = queue.poll();
        }

        System.out.println("===========================");
        for (SoftReference<byte[]> reference : list) {
            System.out.println(reference.get());
        }

    }
}
