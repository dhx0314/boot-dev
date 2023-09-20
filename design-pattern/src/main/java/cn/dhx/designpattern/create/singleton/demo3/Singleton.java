package cn.dhx.designpattern.create.singleton.demo3;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/8/14 14:09
 * <p>
 * <p>
 * 双重检查方式
 */
@Slf4j
public class Singleton {

    //私有构造方法
    private Singleton() {
    }

    private static volatile Singleton instance;

    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        //第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实例
        if (instance == null) {
            synchronized (Singleton.class) {
                //抢到锁之后再次判断是否为null
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
