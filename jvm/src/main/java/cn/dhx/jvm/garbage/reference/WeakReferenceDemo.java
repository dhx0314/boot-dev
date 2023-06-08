package cn.dhx.jvm.garbage.reference;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author daihongxin
 * @create 2023/6/8 10:32
 */
@Slf4j
public class WeakReferenceDemo {

    private static final int _4MB = 4 * 1024 * 1024;

    /**
     * 演示弱引用
     * -Xmx20m -XX:+PrintGCDetails -verbose:gc
     */
    public static void main(String[] args) {
        //  list --> WeakReference --> byte[]
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> w : list) {
                System.out.print(w.get()+" ");
            }
            System.out.println();

        }
        System.out.println("循环结束：" + list.size());
    }
}
