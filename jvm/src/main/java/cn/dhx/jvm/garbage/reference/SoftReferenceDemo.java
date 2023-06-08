package cn.dhx.jvm.garbage.reference;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author daihongxin
 * @create 2023/6/8 10:12
 * <p>
 * 软引用
 */
@Slf4j
public class SoftReferenceDemo {


    private static final int _4MB = 4 * 1024 * 1024;




    // -Xmx20m -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) {
        soft();
    }


    public static void soft() {
        // list --> SoftReference --> byte[]

        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB]);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        System.out.println("循环结束：" + list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }
}
