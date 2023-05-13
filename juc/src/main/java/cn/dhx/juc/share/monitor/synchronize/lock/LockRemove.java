package cn.dhx.juc.share.monitor.synchronize.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/5/13 15:34
 */
@Slf4j
public class LockRemove {

    static int x = 0;


    @Test
    public void lockRemove() {
        fun1();
        fun2();
        // 方法1和方法2的执行效率是一样的
    }

    public void fun1() {
        x++;
    }

    public void fun2() {
        Object o = new Object();
        synchronized (o) {
            x++;
        }
    }
}
