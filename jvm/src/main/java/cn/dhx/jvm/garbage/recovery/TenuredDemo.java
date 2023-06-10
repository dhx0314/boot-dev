package cn.dhx.jvm.garbage.recovery;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @Author daihongxin
 * @create 2023/6/10 0:18
 * 大对象处理策略
 * 年轻代内存 不够会直接分配在老年代
 */
@Slf4j
public class TenuredDemo {

    private static final int _8MB = 8 * 1024 * 1024;

    // -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc -XX:-ScavengeBeforeFullGC
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        log.info("start");
        list.add(new byte[_8MB]);
    }
}
