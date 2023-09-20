package cn.dhx.designpattern.create.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/8/14 14:20
 */
@Slf4j
public class MySingleton {


    //私有构造方法
    private MySingleton() {

        /*
           反射破解单例模式需要添加的代码
        */
        if(instance != null) {
            throw new RuntimeException();
        }
    }

    private static volatile MySingleton instance;

    //对外提供静态方法获取该对象
    public static MySingleton getInstance() {
        //第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实例
        if (instance == null) {
            synchronized (MySingleton.class) {
                //抢到锁之后再次判断是否为null
                if (instance == null) {
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }


    /**
     * 下面是为了解决序列化反序列化破解单例模式
     */
    private Object readResolve() {
        return instance;
    }

}
