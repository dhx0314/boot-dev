package cn.dhx.juc.share.monitor.synchronize.safe;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Author daihongxin
 * @create 2023/5/10 21:18
 */
@Slf4j
public class MyThreadVariable {

    static int LOOP_NUMBER = 200;

    @Test
    public void ThreadUnSafeFun() throws InterruptedException {
        ThreadUnSafe threadUnSafe = new ThreadUnSafe();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                threadUnSafe.method1(LOOP_NUMBER);
            }).start();
        }
        TimeUnit.SECONDS.sleep(5);

        //Exception in thread "Thread-0" Exception in thread "Thread-1" java.lang.ArrayIndexOutOfBoundsException: -1
        //java.lang.IndexOutOfBoundsException: Index: 0, Size: -1
    }


    @Test
    public void ThreadSafeFun() throws InterruptedException {
        ThreadSafe ThreadSafe = new ThreadSafe();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                ThreadSafe.method1(LOOP_NUMBER);
            }).start();
        }
        TimeUnit.SECONDS.sleep(5);
    }


    @Test
    public void ThreadUnSafeSubFun() throws InterruptedException {
        TheadSafeSubClass threadUnSafe = new TheadSafeSubClass();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                threadUnSafe.method1(LOOP_NUMBER*10);
            }).start();
        }
        TimeUnit.SECONDS.sleep(5);
    }
}

class ThreadUnSafe {

    ArrayList<String> list = new ArrayList<>();

    public void method1(int loopNumber) {
        for (int i = 0; i < loopNumber; i++) {
            method2();
            method3();
        }
    }
    // 线程1和线程2同时add  只add了一个原始，remove了两次

    private void method2() {
        list.add("aa");
    }

    private void method3() {
        list.remove(0);
    }
}


class ThreadSafe {


    public void method1(int loopNumber) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < loopNumber; i++) {
            method2(list);
            method3(list);
        }
    }

    public void method2(ArrayList<String> list) {
        list.add("aa");
    }

    public void method3(ArrayList<String> list) {
        list.remove(0);
    }
}

@Slf4j
class TheadSafeSubClass extends ThreadSafe{

    @Override
    public void method3(ArrayList<String> list) {
//        log.info("method3");
         new Thread(() -> {
            list.remove(0);
        }).start();

    }
}