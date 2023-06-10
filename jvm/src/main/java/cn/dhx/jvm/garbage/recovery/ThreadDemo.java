package cn.dhx.jvm.garbage.recovery;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @Author daihongxin
 * @create 2023/6/10 0:25
 *
 * 里面的线程oom 不影响主线程
 */
@Slf4j
public class ThreadDemo {


    private static final int _8MB = 8 * 1024 * 1024;

    // -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc -XX:-ScavengeBeforeFullGC
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            ArrayList<byte[]> list = new ArrayList<>();
            list.add(new byte[_8MB]);
            list.add(new byte[_8MB]);
        }).start();
        //主线程还是会正常执行
        System.out.println("sleep....");
        Thread.sleep(1000L);
    }
}
