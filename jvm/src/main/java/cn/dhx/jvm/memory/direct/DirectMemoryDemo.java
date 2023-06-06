package cn.dhx.jvm.memory.direct;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/6/6 9:30
 */
@Slf4j
public class DirectMemoryDemo {

    @Test
    public void fun1() throws Exception {
        //分配1024MB直接缓存
        ByteBuffer bb = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
        TimeUnit.SECONDS.sleep(10);
        //清除直接缓存
        ((DirectBuffer) bb).cleaner().clean();
        System.out.println("ok");
    }

    static int _1Gb = 1024 * 1024 * 1024;

    @Test
    public void fun2() throws IOException {


        Unsafe unsafe = getUnsafe();
        // 分配内存
        long base = unsafe.allocateMemory(_1Gb);
        unsafe.setMemory(base, _1Gb, (byte) 0);
        System.in.read();

        // 释放内存
        unsafe.freeMemory(base);
        System.in.read();


    }

    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);
            return unsafe;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void fun4() throws IOException {
        /*
         * -XX:+DisableExplicitGC 显式的  禁用显式回收对直接内存的影响
         */
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1Gb);
        System.out.println("分配完毕...");
        System.in.read();
        System.out.println("开始释放...");
        byteBuffer = null;
        System.gc(); // 显式的垃圾回收，Full GC
        System.in.read();
    }


    static int _100Mb = 1024 * 1024 * 100;

    /**
     * 演示直接内存溢出
     * java.lang.OutOfMemoryError: Direct buffer memory
     */
    @Test
    public void fun5() {
        List<ByteBuffer> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100Mb);
                list.add(byteBuffer);
                i++;
            }
        } finally {
            System.out.println(i);
        }
    }


}
