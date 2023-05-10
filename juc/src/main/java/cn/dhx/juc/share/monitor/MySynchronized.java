package cn.dhx.juc.share.monitor;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author daihongxin
 * @create 2023/5/10 20:16
 */
@Slf4j
public class MySynchronized {

}

class TestDemo {
    public synchronized void test() {

    }
    //    等价于
    public void test1() {
        synchronized (this) {

        }
    }
}



class TestDemo2 {
    public static synchronized void test() {

    }
    //    等价于
    public void test1() {
        synchronized (TestDemo2.class) {

        }
    }
}