package cn.dhx.juc.share.memory.single;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/5/17 21:56
 */
@Slf4j
public class Singleton3 {


    private static Singleton3 INSTANCE = null;

    private Singleton3() {

    }


    // 锁的范围有点大,每次获取单例对象都要枷锁
    private static synchronized Singleton3 getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        INSTANCE = new Singleton3();
        return INSTANCE;
    }

}
