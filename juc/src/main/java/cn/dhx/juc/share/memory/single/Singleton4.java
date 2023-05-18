package cn.dhx.juc.share.memory.single;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/5/17 21:56
 */
@Slf4j
public class Singleton4 {

    // volatile   防止指令重排序
    private static volatile Singleton4 INSTANCE = null;

    private Singleton4() {

    }

    private static  Singleton4 getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (Singleton4.class) {
            // 防止首次创建  多个线程并发创建 instance
            if (INSTANCE != null) {
                return INSTANCE;
            }
            INSTANCE = new Singleton4();
            return INSTANCE;
        }

    }
}
