package cn.dhx.juc.share.monitor.synchronize.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/5/12 23:25
 * 轻量级锁
 */

@Slf4j
public class LightweightLocked {

    @Test
    public void fun1() {
        Lightweight.method1();
    }


}

class Lightweight {
    static final Object obj = new Object();

    public static void method1() {
        synchronized (obj) {
            // 同步块 A
            method2();
        }
    }

    public static void method2() {
        synchronized (obj) {
            // 同步块 B
        }
    }
}

class LockExpansion {
    static Object obj = new Object();

    public static void method1() {
        synchronized (obj) {
            // 同步块
        }
    }
}


