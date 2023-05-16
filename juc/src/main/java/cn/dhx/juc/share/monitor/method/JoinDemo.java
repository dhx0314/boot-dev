package cn.dhx.juc.share.monitor.method;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author daihongxin
 * @create 2023/5/15 22:01
 */
@Slf4j
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread();
        t1.join();

        synchronized (t1) {
            // 调用者线程进入 t1 的 waitSet 等待, 直到 t1 运行结束
            while (t1.isAlive()) {
                t1.wait(0);
            }
        }
    }
}
