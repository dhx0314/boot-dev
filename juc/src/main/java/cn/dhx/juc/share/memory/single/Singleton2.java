package cn.dhx.juc.share.memory.single;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/5/17 21:56
 */
@Slf4j
public enum Singleton2 {
    INSTANCE,
    ;

    // 枚举对象是静态成员变量，定义时有几个将来就有几个
    // 创建时线程安全
    // 不能被反射破坏单例
    // 可以避免反序列破坏单例
    // 属于饿汉式
    // 新增一个构造方法可以在初始化中加入一些逻辑
}
