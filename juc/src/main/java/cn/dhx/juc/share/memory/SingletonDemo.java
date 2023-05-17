package cn.dhx.juc.share.memory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/5/17 15:52
 */
@Slf4j
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }



}

//
//class Singleton {
//    private Singleton() {
//    }
//
//    private static Singleton INSTANCE = null;
//
//    public static Singleton getInstance() {
//        if (INSTANCE == null) { // t2
//            // 首次访问会同步，而之后的使用没有 synchronized
//            synchronized (Singleton.class) {
//                if (INSTANCE == null) { // t1
//                    INSTANCE = new Singleton();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//}

class Singleton {
    private Singleton() {
    }

    private static volatile Singleton INSTANCE = null;

    public static Singleton getInstance() {
        // 实例没创建，才会进入内部的 synchronized代码块
        if (INSTANCE == null) {
            synchronized (Singleton.class) { // t2
                // 也许有其它线程已经创建实例，所以再判断一次
                if (INSTANCE == null) { // t1
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}


