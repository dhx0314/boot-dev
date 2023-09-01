package cn.dhx.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/8/31 9:32
 */
@Slf4j
public class MyThreadLocal {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {
        // 创建两个线程
        Thread thread1 = new Thread(() -> {
            // 在线程1设置 ThreadLocal 的值
            threadLocal.set("Hello from Thread1");
            // 在线程1获取 ThreadLocal 的值并打印
            System.out.println("Thread1: " + threadLocal.get());
            // 线程1结束后，需要调用 remove 方法清除 ThreadLocal 的值
            threadLocal.remove();
        });

        Thread thread2 = new Thread(() -> {
            // 在线程2设置 ThreadLocal 的值
            threadLocal.set("Hello from Thread2");
            // 在线程2获取 ThreadLocal 的值并打印
            System.out.println("Thread2: " + threadLocal.get());
            // 线程2结束后，需要调用 remove 方法清除 ThreadLocal 的值
            threadLocal.remove();
        });

        // 启动两个线程
        thread1.start();
        thread2.start();
    }

}
