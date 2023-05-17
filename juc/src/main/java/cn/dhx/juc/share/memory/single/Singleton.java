package cn.dhx.juc.share.memory.single;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Author daihongxin
 * @create 2023/5/17 21:50
 */
@Slf4j
// final 不能被继承,防止子类破坏单例
public final class Singleton implements Serializable {


    // 构造方法私有，不能防止反射创建新的实例
    private Singleton() {
    }

    // 这样初始化是能保证单例对象创建时的线程安全
    // 类加载阶段 线程安全
    private static final Singleton INSTANCE = new Singleton();

    // 为什么提供静态方法而不是直接将 INSTANCE 设置为 public, 说出你知道的理由
    // 提供封装,提供泛型支持
    // 后续可以调整成懒惰模式
    public static Singleton getInstance() {
        return INSTANCE;
    }

    // 从序列化中恢复一个单例对象会破坏单例模式，解决方法是添加readResolve();
    // 当我们通过反序列化readObject()方法获取对象时会去寻找readResolve()方法，
    // 如果该方法不存在则直接返回新对象，如果该方法存在则按该方法的内容返回对象,
    // 以确保如果我们之前实例化了单例对象，就返回该对象。
    // 如果我们之前没有实例化单例对象，则会返回null
    public Object readResolve() {
        return INSTANCE;
    }
}
