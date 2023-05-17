package cn.dhx.juc.share.memory.single;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/5/17 21:56
 * 静态内部类实现单例
 */
@Slf4j
public class Singleton5 {


    private static Singleton5 INSTANCE = null;

    // 懒汉式
    // 类加载是懒汉式
    private static class LazyHolder {
        static final Singleton5 INSTANCE = new Singleton5();
    }

    // 线程安全的 jvm类加载线程安全
    private static Singleton5 getInstance() {
        return LazyHolder.INSTANCE;
    }

}
