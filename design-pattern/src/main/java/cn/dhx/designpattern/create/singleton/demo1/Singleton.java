package cn.dhx.designpattern.create.singleton.demo1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/8/14 14:05
 */

/**
 * 饿汉式
 * 静态变量创建类的对象
 */
@Slf4j
public class Singleton {
    //私有构造方法
    private Singleton() {

    }

    //在成员位置创建该类的对象
    private static Singleton instance = new Singleton();

    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        return instance;
    }
}